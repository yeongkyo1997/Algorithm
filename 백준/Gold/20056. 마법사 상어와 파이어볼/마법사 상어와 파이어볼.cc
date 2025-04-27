#include <iostream>
#include <vector>
using namespace std;

// 파이어볼 구조체
struct Fireball {
    int r, c;   // 위치 (0-based)
    int m, s;   // 질량, 속력
    int d;      // 방향
};

int N, M, K;
// 8방향 (문제의 디렉션 순서: 0 위, 1 우상, 2 우, 3 우하, 4 아래, 5 좌하, 6 좌, 7 좌상)
int dr[8] = { -1, -1, 0, 1, 1, 1, 0, -1 };
int dc[8] = {  0,  1, 1, 1, 0, -1, -1, -1 };

// 각 칸에 모인 파이어볼을 임시 저장할 그리드
vector<Fireball> grid[50][50];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M >> K;

    // 초기 파이어볼 목록
    vector<Fireball> fb;
    fb.reserve(M);
    for (int i = 0; i < M; i++) {
        int r, c, m, s, d;
        cin >> r >> c >> m >> s >> d;
        fb.push_back({r-1, c-1, m, s, d});
    }

    // K번 이동 및 합체-분할
    while (K--) {
        // 1) 그리드 초기화
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                grid[i][j].clear();

        // 2) 모든 파이어볼 이동시키기 (토러스 형태)
        for (auto &f : fb) {
            int step = f.s % N;  // N번 움직이면 원위치
            int nr = f.r + dr[f.d] * step;
            int nc = f.c + dc[f.d] * step;
            // 음수 방지용 모듈러
            nr = (nr % N + N) % N;
            nc = (nc % N + N) % N;
            grid[nr][nc].push_back({nr, nc, f.m, f.s, f.d});
        }
        fb.clear();

        // 3) 같은 칸에 2개 이상 모인 파이어볼 처리
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = grid[i][j].size();
                if (cnt == 0) continue;
                if (cnt == 1) {
                    // 혼자 있으면 그대로 유지
                    fb.push_back(grid[i][j][0]);
                } else {
                    // 합치기
                    long long sum_m = 0, sum_s = 0;
                    int even = 0, odd = 0;
                    for (auto &g : grid[i][j]) {
                        sum_m += g.m;
                        sum_s += g.s;
                        if (g.d % 2 == 0) even++;
                        else odd++;
                    }
                    int nm = sum_m / 5;       // 새 질량
                    if (nm == 0) continue;    // 질량 0 이면 소멸
                    int ns = sum_s / cnt;     // 새 속력

                    // 방향 결정
                    int dirs[4];
                    if (even == cnt || odd == cnt) {
                        dirs[0] = 0; dirs[1] = 2; dirs[2] = 4; dirs[3] = 6;
                    } else {
                        dirs[0] = 1; dirs[1] = 3; dirs[2] = 5; dirs[3] = 7;
                    }
                    // 4개의 파이어볼로 분할
                    for (int k = 0; k < 4; k++) {
                        fb.push_back({i, j, nm, ns, dirs[k]});
                    }
                }
            }
        }
    }

    // 남은 파이어볼 질량 합산
    long long answer = 0;
    for (auto &f : fb) answer += f.m;
    cout << answer << "\n";

    return 0;
}
