#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct State {
    int x, y, keys, moves;
};

int main() {
    int N, M;
    cin >> N >> M;
    vector<vector<char>> grid(N, vector<char>(M));
    int start_x, start_y;
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            cin >> grid[i][j];
            if (grid[i][j] == '0') {
                start_x = i;
                start_y = j;
            }
        }
    }
    
    bool visited[50][50][64] = {false};
    queue<State> q;
    q.push({start_x, start_y, 0, 0});
    visited[start_x][start_y][0] = true;
    
    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};
    
    while (!q.empty()) {
        State current = q.front();
        q.pop();
        
        if (grid[current.x][current.y] == '1') {
            cout << current.moves << endl;
            return 0;
        }
        
        for (int d = 0; d < 4; ++d) {
            int new_x = current.x + dx[d];
            int new_y = current.y + dy[d];
            if (new_x >= 0 && new_x < N && new_y >= 0 && new_y < M) {
                char cell = grid[new_x][new_y];
                if (cell == '#') continue;
                
                int new_keys = current.keys;
                if (cell >= 'A' && cell <= 'F') {
                    int key_needed = cell - 'A';
                    if ((current.keys & (1 << key_needed)) == 0) continue;
                } else if (cell >= 'a' && cell <= 'f') {
                    new_keys |= (1 << (cell - 'a'));
                }
                
                if (!visited[new_x][new_y][new_keys]) {
                    visited[new_x][new_y][new_keys] = true;
                    q.push({new_x, new_y, new_keys, current.moves + 1});
                }
            }
        }
    }
    
    cout << -1 << endl;
    return 0;
}