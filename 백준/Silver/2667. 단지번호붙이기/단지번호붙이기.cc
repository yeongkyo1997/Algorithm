#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <string>

using namespace std;

int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};
vector<int> aparts(25 * 25);
int n;
int apartNum = 0;
vector<vector<bool>> visited(25, vector<bool>(25));
vector<vector<int>> map(25, vector<int>(25));

void bfs(int x, int y) {
    queue<pair<int, int>> que;
    que.push({x, y});
    visited[x][y] = true;
    aparts[apartNum]++;

    while (!que.empty()) {
        int curX = que.front().first;
        int curY = que.front().second;
        que.pop();

        for (int i = 0; i < 4; i++) {
            int nx = curX + dx[i];
            int ny = curY + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    que.push({nx, ny});
                    visited[nx][ny] = true;
                    aparts[apartNum]++;
                }
            }
        }
    }
}

int main() {
    cin >> n;

    map = vector<vector<int>>(n, vector<int>(n));
    visited = vector<vector<bool>>(n, vector<bool>(n));

    // 전체 사각형 입력 받기
    for (int i = 0; i < n; i++) {
        string input;
        cin >> input;
        for (int j = 0; j < n; j++) {
            map[i][j] = input[j] - '0';
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (map[i][j] == 1 && !visited[i][j]) {
                apartNum++;
                bfs(i, j);
            }
        }
    }

    sort(aparts.begin(), aparts.end());
    cout << apartNum << endl;

    for (int i = 0; i < aparts.size(); i++) {
        if (aparts[i] != 0) {
            cout << aparts[i] << endl;
        }
    }

    return 0;
}