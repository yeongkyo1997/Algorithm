#include <iostream>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int n;
int space[20][20];
int dx[] = {-1, 0, 1, 0};
int dy[] = {0, -1, 0, 1};

bool valid(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < n;
}

int main() {
    cin >> n;

    int shark_x, shark_y;
    int shark_size = 2;
    int eaten_fish = 0;
    int time = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> space[i][j];
            if (space[i][j] == 9) {
                shark_x = i;
                shark_y = j;
                space[i][j] = 0;
            }
        }
    }

    while (true) {
        vector<vector<bool>> visited(n, vector<bool>(n, false));
        visited[shark_x][shark_y] = true;
        queue<tuple<int, int, int>> q;
        q.push(make_tuple(shark_x, shark_y, 0));

        int target_x = -1, target_y = -1, target_dist = -1;

        while (!q.empty()) {
            int x, y, dist;
            tie(x, y, dist) = q.front();
            q.pop();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (valid(nx, ny) && !visited[nx][ny] && space[nx][ny] <= shark_size) {
                    visited[nx][ny] = true;
                    q.push(make_tuple(nx, ny, dist + 1));

                    if (space[nx][ny] > 0 && space[nx][ny] < shark_size) {
                        if (target_dist == -1 || target_dist > dist + 1 || (target_dist == dist + 1 && (target_x > nx || (target_x == nx && target_y > ny)))) {
                            target_x = nx;
                            target_y = ny;
                            target_dist = dist + 1;
                        }
                    }
                }
            }
        }

        if (target_dist == -1) break;

        shark_x = target_x;
        shark_y = target_y;
        space[shark_x][shark_y] = 0;
        time += target_dist;
        eaten_fish++;

        if (eaten_fish == shark_size) {
            shark_size++;
            eaten_fish = 0;
        }
    }

    cout << time << '\n';

    return 0;
}