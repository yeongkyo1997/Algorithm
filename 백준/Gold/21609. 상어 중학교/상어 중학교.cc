#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <cstring>
using namespace std;

int N, M;
int grid[20][20];
int score = 0;

// 네 방향 델타
int dr[4] = { -1, 1, 0, 0 };
int dc[4] = { 0, 0, -1, 1 };

// 중력 적용: 블록(-1 제외)이 빈칸(-2)으로 아래로 떨어짐
void applyGravity() {
    for (int c = 0; c < N; c++) {
        int bottom = N - 1;
        for (int r = N - 1; r >= 0; r--) {
            if (grid[r][c] == -1) {
                // 검은 블록은 고정 장애물
                bottom = r - 1;
            }
            else if (grid[r][c] >= 0) {
                // 일반 또는 무지개 블록
                int v = grid[r][c];
                grid[r][c] = -2;        // 원래 자리 비움
                grid[bottom][c] = v;    // 아래로 내림
                bottom--;
            }
        }
    }
}

// 90도 반시계 회전
void rotateCCW() {
    static int tmp[20][20];
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            tmp[N - 1 - j][i] = grid[i][j];
        }
    }
    // 다시 복사
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            grid[i][j] = tmp[i][j];
}

// 블록 그룹 정보 구조체
struct Group {
    int size;           // 그룹 크기
    int rainbowCnt;     // 무지개 블록 수
    int stdR, stdC;     // 기준 블록 좌표
    vector<pair<int,int>> cells;
};

// 한 단계 오토 플레이: 최대 그룹 찾아 제거 → 점수 → 중력→회전→중력
// 제거할 그룹이 없으면 false, 제거했으면 true 반환
bool playOnce() {
    bool visited[20][20] = {false};
    vector<Group> groups;

    // 모든 칸을 돌며 BFS로 그룹 탐색
    for (int r = 0; r < N; r++) {
        for (int c = 0; c < N; c++) {
            int color = grid[r][c];
            // 시작은 일반 블록(1~M)이어야 하고, 아직 방문 안 된 칸
            if (color <= 0 || visited[r][c]) continue;

            queue<pair<int,int>> q;
            bool seen[20][20] = {false};
            q.push(make_pair(r,c));
            seen[r][c] = true;

            Group g;
            g.size = 0;
            g.rainbowCnt = 0;
            g.stdR = r;
            g.stdC = c;
            vector<pair<int,int>> all;

            while (!q.empty()) {
                pair<int,int> cur = q.front(); q.pop();
                int cr = cur.first;
                int cc = cur.second;
                all.push_back(cur);
                g.size++;
                if (grid[cr][cc] == 0) {
                    // 무지개 블록 카운트
                    g.rainbowCnt++;
                } else {
                    // 일반 블록: 기준 블록 갱신 (행·열 최소)
                    if (cr < g.stdR || (cr == g.stdR && cc < g.stdC)) {
                        g.stdR = cr;
                        g.stdC = cc;
                    }
                }
                // 인접 4칸 탐색
                for (int d = 0; d < 4; d++) {
                    int nr = cr + dr[d];
                    int nc = cc + dc[d];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    if (seen[nr][nc]) continue;
                    // 같은 색 또는 무지개(0)이면 그룹에 포함
                    if (grid[nr][nc] == color || grid[nr][nc] == 0) {
                        seen[nr][nc] = true;
                        q.push(make_pair(nr,nc));
                    }
                }
            }

            // 그룹 크기 최소 2 이상이어야 유효
            if (g.size >= 2) {
                g.cells = all;
                groups.push_back(g);
            }

            // 이 그룹의 일반 블록만 방문 처리 (무지개는 여러 그룹에 속할 수 있어서)
            for (auto &p : all) {
                int rr = p.first, cc2 = p.second;
                if (grid[rr][cc2] != 0) {
                    visited[rr][cc2] = true;
                }
            }
        }
    }

    // 유효 그룹 없으면 종료
    if (groups.empty()) return false;

    // 우선순위대로 정렬: 크기 → 무지개 수 → 기준 블록 행(내림) → 열(내림)
    sort(groups.begin(), groups.end(), [](const Group &a, const Group &b){
        if (a.size != b.size) return a.size > b.size;
        if (a.rainbowCnt != b.rainbowCnt) return a.rainbowCnt > b.rainbowCnt;
        if (a.stdR != b.stdR) return a.stdR > b.stdR;
        return a.stdC > b.stdC;
    });

    Group &best = groups[0];
    // 선택된 그룹 제거 (빈 칸=-2)
    for (auto &p : best.cells) {
        grid[p.first][p.second] = -2;
    }
    // 점수 추가
    score += best.size * best.size;

    // 중력 → 90° 반시계 회전 → 중력
    applyGravity();
    rotateCCW();
    applyGravity();

    return true;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M;
    for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++){
            cin >> grid[i][j];
        }
    }
    // 빈 칸 표현을 위해 -2 로 초기화(입력엔 없으므로 생략해도 무방)
    // memset(grid, -2, sizeof(grid)); 

    // 오토 플레이 반복
    while (playOnce()) {
        // 더 이상 제거할 그룹이 없으면 playOnce()가 false를 반환
    }

    // 최종 점수 출력
    cout << score << "\n";
    return 0;
}
