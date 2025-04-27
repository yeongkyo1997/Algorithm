#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false); // C I/O 비동기 해제
    cin.tie(nullptr);            // cin/cout 연결 해제

    int R, C;
    cin >> R >> C;

    vector<string> patch(R);
    for (int i = 0; i < R; i++) {
        cin >> patch[i]; // 호박/짚더미 배열 입력
    }

    int A, B;
    cin >> A >> B; // 시작 위치

    // 방문 체크 배열
    vector<vector<bool>> vis(R, vector<bool>(C, false));
    // 이동 방향 (상, 하, 좌, 우)
    int dr[4] = {-1, 1, 0, 0};
    int dc[4] = {0, 0, -1, 1};

    long long total = 0;
    queue<pair<int,int>> q;
    // 시작 지점이 짚더미(*)면 아무 것도 못 얻음
    if (patch[A][B] != '*') {
        q.push({A, B});
        vis[A][B] = true;
    }

    while (!q.empty()) {
        auto [r, c] = q.front(); q.pop();
        // 호박 종류에 따라 값 더하기
        if (patch[r][c] == 'S') total += 1;
        else if (patch[r][c] == 'M') total += 5;
        else if (patch[r][c] == 'L') total += 10;
        // 인접 4방향 탐색
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            // 범위 체크 및 미방문, 짚더미가 아니어야 함
            if (nr >= 0 && nr < R && nc >= 0 && nc < C 
                && !vis[nr][nc] && patch[nr][nc] != '*') {
                vis[nr][nc] = true;
                q.push({nr, nc});
            }
        }
    }

    cout << total << "\n";
    return 0;
}
