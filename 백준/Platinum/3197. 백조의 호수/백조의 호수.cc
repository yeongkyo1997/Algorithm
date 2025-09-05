#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int R, C;
    if (!(cin >> R >> C)) return 0;
    vector<string> lake(R);
    for (int i = 0; i < R; ++i) cin >> lake[i];

    // Directions: up, down, left, right
    const int dr[4] = {-1, 1, 0, 0};
    const int dc[4] = {0, 0, -1, 1};

    // Find swans and initialize queues
    pair<int,int> swan[2];
    int sidx = 0;

    queue<pair<int,int>> waterQ, nextWaterQ;
    queue<pair<int,int>> swanQ, nextSwanQ;

    vector<vector<char>> waterVis(R, vector<char>(C, 0));
    vector<vector<char>> swanVis(R, vector<char>(C, 0));

    for (int r = 0; r < R; ++r) {
        for (int c = 0; c < C; ++c) {
            if (lake[r][c] != 'X') {
                waterQ.emplace(r, c);
                waterVis[r][c] = 1;
            }
            if (lake[r][c] == 'L') {
                swan[sidx++] = {r, c};
            }
        }
    }

    // Swan BFS init
    swanQ.emplace(swan[0]);
    swanVis[swan[0].first][swan[0].second] = 1;

    auto swan_expand = [&]() -> bool {
        while (!swanQ.empty()) {
            auto [r, c] = swanQ.front(); swanQ.pop();
            // Reached the other swan
            if (r == swan[1].first && c == swan[1].second) return true;

            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if (swanVis[nr][nc]) continue;
                swanVis[nr][nc] = 1;

                if (lake[nr][nc] == 'X') {
                    // Can't pass today; try tomorrow
                    nextSwanQ.emplace(nr, nc);
                } else {
                    // Water or swan cell: move today
                    swanQ.emplace(nr, nc);
                }
            }
        }
        return false;
    };

    auto water_melt = [&]() {
        while (!waterQ.empty()) {
            auto [r, c] = waterQ.front(); waterQ.pop();
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if (waterVis[nr][nc]) continue;
                waterVis[nr][nc] = 1;

                if (lake[nr][nc] == 'X') {
                    lake[nr][nc] = '.';           // melt for next day
                    nextWaterQ.emplace(nr, nc);   // will be water tomorrow
                } else {
                    // Already water, continue spreading today
                    waterQ.emplace(nr, nc);
                }
            }
        }
    };

    int days = 0;
    while (true) {
        if (swan_expand()) {
            cout << days << '\n';
            break;
        }
        water_melt();
        ++days;

        // Move to next day
        swap(swanQ, nextSwanQ);
        swap(waterQ, nextWaterQ);
        nextSwanQ = queue<pair<int,int>>();
        nextWaterQ = queue<pair<int,int>>();
    }

    return 0;
}