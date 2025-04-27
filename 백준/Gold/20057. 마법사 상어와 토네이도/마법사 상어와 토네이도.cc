#include <iostream>
#include <vector>
using namespace std;
using ll = long long;

// 최대 격자 크기
int N;
// 모래판
int A[500][500];
// 토네이도 현재 위치 (행,열)
int tr, tc;
// 격자 밖으로 나간 모래 합
ll answer = 0;

// 토네이도 이동 방향: 0=왼쪽,1=아래,2=오른쪽,3=위
int dr[4] = { 0, 1, 0, -1 };
int dc[4] = { -1, 0, 1, 0 };

// 기본 흩날림 오프셋 (왼쪽 방향 기준)
// {행 오프셋, 열 오프셋, 비율}
// 1%: (-1,1), (1,1)
// 7%: (-1,0), (1,0)
// 2%: (-2,0), (2,0)
// 10%:(-1,-1),(1,-1)
// 5%: (0,-2)
int base_off[9][3] = {
    {-1,  1, 1}, { 1,  1, 1},
    {-1,  0, 7}, { 1,  0, 7},
    {-2,  0, 2}, { 2,  0, 2},
    {-1, -1,10}, { 1, -1,10},
    { 0, -2, 5}
};
// α 위치 (왼쪽 기준)
int base_alpha_r = 0;
int base_alpha_c = -1;

// 회전: grid 좌표계에서 90도 반시계 회전
// (dr,dc) -> (dr' = -dc, dc' = dr)
void rotateCCW(int &rr, int &cc) {
    int tmp = rr;
    rr = -cc;
    cc = tmp;
}

// 각 방향별 흩날림 오프셋과 α 오프셋
vector<pair<int,int>> off[4];
pair<int,int> alpha_off[4];
// 비율 배열
int pct[9];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> A[i][j];
        }
    }

    // 토네이도 시작: 중앙
    tr = tc = N / 2;

    // 비율 초기화
    for (int i = 0; i < 9; i++) {
        pct[i] = base_off[i][2];
    }
    // 4방향(왼,아래,오,위)에 대해 회전시킨 오프셋 계산
    for (int d = 0; d < 4; d++) {
        // base_off 9개
        for (int i = 0; i < 9; i++) {
            int rr = base_off[i][0];
            int cc = base_off[i][1];
            // d번 90도 반시계 회전
            for (int k = 0; k < d; k++) {
                rotateCCW(rr, cc);
            }
            off[d].push_back({rr, cc});
        }
        // α 오프셋
        int ar = base_alpha_r;
        int ac = base_alpha_c;
        for (int k = 0; k < d; k++) {
            rotateCCW(ar, ac);
        }
        alpha_off[d] = {ar, ac};
    }

    // 나선형 이동: 왼→아래→오른→위 순서, 같은 길이 두 번, 길이 1씩 증가
    int dir = 0;    // 현재 방향 인덱스
    int length = 1; // 한 번에 이동할 칸 수
    bool finished = false;

    while (!finished) {
        // 같은 길이로 두 번 이동
        for (int t = 0; t < 2 && !finished; t++) {
            for (int s = 0; s < length; s++) {
                // 한 칸 이동
                tr += dr[dir];
                tc += dc[dir];
                // 이동한 칸의 모래 흩날리기
                int sand = A[tr][tc];
                A[tr][tc] = 0;
                int used = 0;
                // 비율별 9개 위치
                for (int i = 0; i < 9; i++) {
                    int nr = tr + off[dir][i].first;
                    int nc = tc + off[dir][i].second;
                    int amt = (sand * pct[i]) / 100;
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                        answer += amt;
                    } else {
                        A[nr][nc] += amt;
                    }
                    used += amt;
                }
                // α 위치로 남은 모래
                int ar = tr + alpha_off[dir].first;
                int ac = tc + alpha_off[dir].second;
                int alpha_amt = sand - used;
                if (ar < 0 || ar >= N || ac < 0 || ac >= N) {
                    answer += alpha_amt;
                } else {
                    A[ar][ac] += alpha_amt;
                }
                // (0,0)에 도달하면 종료
                if (tr == 0 && tc == 0) {
                    finished = true;
                    break;
                }
            }
            // 방향 전환
            dir = (dir + 1) % 4;
        }
        // 이동 길이 증가
        length++;
    }

    // 결과 출력
    cout << answer << "\n";
    return 0;
}
