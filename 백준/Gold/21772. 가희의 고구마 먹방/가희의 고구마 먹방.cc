#include <bits/stdc++.h>
using namespace std;

struct State {
    int x, y;
    int time_left;
    int mask;
    int count;

    bool operator<(const State& other) const {
        return count < other.count; // Max-heap based on count
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int R, C, T;
    cin >> R >> C >> T;

    vector<string> grid(R);
    int gx, gy;
    for (int i = 0; i < R; ++i) {
        cin >> grid[i];
        for (int j = 0; j < C; ++j) {
            if (grid[i][j] == 'G') {
                gx = i;
                gy = j;
                grid[i][j] = '.'; // Mark as walkable
            }
        }
    }

    // Compute BFS from G to get minimal distances
    vector<vector<int>> dist(R, vector<int>(C, -1));
    queue<pair<int, int>> q;
    q.emplace(gx, gy);
    dist[gx][gy] = 0;

    const int dx[] = {-1, 1, 0, 0};
    const int dy[] = {0, 0, -1, 1};

    while (!q.empty()) {
        auto pos = q.front();
    q.pop();
    int x = pos.first;
    int y = pos.second;
        for (int d = 0; d < 4; ++d) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C && grid[nx][ny] != '#' && dist[nx][ny] == -1) {
                dist[nx][ny] = dist[x][y] + 1;
                q.emplace(nx, ny);
            }
        }
    }

    // Collect S's reachable within T steps
    vector<pair<int, int>> S_list;
    map<pair<int, int>, int> S_index;
    for (int i = 0; i < R; ++i) {
        for (int j = 0; j < C; ++j) {
            if (grid[i][j] == 'S' && dist[i][j] != -1 && dist[i][j] <= T) {
                S_list.emplace_back(i, j);
                S_index[{i, j}] = S_list.size() - 1;
            }
        }
    }

    int M = S_list.size();
    if (M == 0) {
        cout << 0 << endl;
        return 0;
    }

    // DP structure: dp[x][y][t][mask] = max_count
    vector<vector<vector<unordered_map<int, int>>>> dp(
        R, vector<vector<unordered_map<int, int>>>(
            C, vector<unordered_map<int, int>>(T + 1)));

    priority_queue<State> pq;
    pq.push({gx, gy, T, 0, 0});
    dp[gx][gy][T][0] = 0;

    int max_count = 0;

    while (!pq.empty()) {
        State current = pq.top();
        pq.pop();

        if (current.count < dp[current.x][current.y][current.time_left][current.mask])
            continue;

        if (current.time_left == 0) {
            max_count = max(max_count, current.count);
            continue;
        }

        for (int d = 0; d < 5; ++d) {
            int nx = current.x;
            int ny = current.y;
            if (d < 4) {
                nx += dx[d];
                ny += dy[d];
            }
            if (nx < 0 || nx >= R || ny < 0 || ny >= C || grid[nx][ny] == '#')
                continue;

            int new_mask = current.mask;
            int new_count = current.count;

            if (grid[nx][ny] == 'S') {
                auto it = S_index.find({nx, ny});
                if (it != S_index.end()) {
                    int idx = it->second;
                    if (!(new_mask & (1 << idx))) {
                        new_mask |= (1 << idx);
                        new_count++;
                    }
                }
            }

            int new_time = current.time_left - 1;
            auto& curr_dp = dp[nx][ny][new_time];
            if (curr_dp.find(new_mask) == curr_dp.end() || new_count > curr_dp[new_mask]) {
                curr_dp[new_mask] = new_count;
                pq.push({nx, ny, new_time, new_mask, new_count});
            }
        }
    }

    cout << max_count << endl;

    return 0;
}