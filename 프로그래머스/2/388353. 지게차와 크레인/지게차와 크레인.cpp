#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(vector<string> storage, vector<string> requests) {
    int n = storage.size();
    int m = storage[0].size();
    vector<vector<char>> grid(n, vector<char>(m));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            grid[i][j] = storage[i][j];
        }
    }
    
    int dx[4] = { -1, 1, 0, 0 };
    int dy[4] = { 0, 0, -1, 1 };

    for (string req : requests) {
        char target = req[0]; 
        if (req.size() == 2) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == target)
                        grid[i][j] = '.'; 
                }
            }
        }
        else {
            vector<vector<bool>> external(n, vector<bool>(m, false));
            queue<pair<int, int>> q;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && grid[i][j] == '.') {
                        external[i][j] = true;
                        q.push({i, j});
                    }
                }
            }
            while (!q.empty()) {
                auto [x, y] = q.front();
                q.pop();
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                        continue;
                    if (grid[nx][ny] == '.' && !external[nx][ny]) {
                        external[nx][ny] = true;
                        q.push({nx, ny});
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == target) {
                        bool accessible = false;
                        if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                            accessible = true;
                        } else {
                            for (int k = 0; k < 4; k++) {
                                int nx = i + dx[k];
                                int ny = j + dy[k];
                                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                                    continue;
                                if (grid[nx][ny] == '.' && external[nx][ny]) {
                                    accessible = true;
                                    break;
                                }
                            }
                        }
                        if (accessible)
                            grid[i][j] = '.'; 
                    }
                }
            }
        }
    }
    
    int cnt = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (grid[i][j] != '.')
                cnt++;
        }
    }
    return cnt;
}
