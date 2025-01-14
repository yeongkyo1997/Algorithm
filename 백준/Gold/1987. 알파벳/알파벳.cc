#include <bits/stdc++.h>
using namespace std;

// 방향 벡터: 상, 하, 좌, 우
int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

// 전역 변수로 최대 경로 길이를 저장
int max_path = 0;

// DFS 함수
void dfs(int x, int y, int R, int C, vector<string> &board, int visited, int count) {
    // 현재 최대 경로 길이 갱신
    if(count > max_path) {
        max_path = count;
        // 최적화: 모든 알파벳을 방문한 경우, 더 이상 탐색할 필요 없음
        if(max_path == 26) return;
    }

    // 상, 하, 좌, 우로 이동
    for(int dir = 0; dir < 4; dir++) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        // 보드 범위 내인지 확인
        if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
            char next_char = board[nx][ny];
            int bit = next_char - 'A';
            // 해당 알파벳을 이미 방문했는지 확인
            if( (visited & (1 << bit)) == 0 ) {
                // 방문 표시
                dfs(nx, ny, R, C, board, visited | (1 << bit), count + 1);
                // 비트마스킹을 사용하기 때문에 백트래킹 시 별도의 복구가 필요 없음
            }
        }
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int R, C;
    cin >> R >> C;
    vector<string> board(R);
    for(int i = 0; i < R; i++) {
        cin >> board[i];
    }

    // 시작 위치 (0,0)의 알파벳 비트 설정
    int start_char = board[0][0] - 'A';
    int visited = (1 << start_char);

    // DFS 시작
    dfs(0, 0, R, C, board, visited, 1);

    cout << max_path << "\n";

    return 0;
}