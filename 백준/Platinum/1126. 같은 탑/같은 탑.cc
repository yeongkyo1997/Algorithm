#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>

using namespace std;

int N, total;
vector<int> blocks;
vector<vector<int>> dp;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;
    blocks.resize(N);
    total = 0;
    for (int i = 0; i < N; i++) {
        cin >> blocks[i];
        total += blocks[i];
    }

    int half = total / 2;
    dp = vector<vector<int>>(N, vector<int>(total + 1, -1));
    dp[0][0] = 0;
    dp[0][blocks[0]] = blocks[0];

    for (int i = 1; i < N; i++) {
        for (int j = 0; j <= total; j++) {
            if (dp[i - 1][j] == -1) {
                continue;
            }
            dp[i][j] = max(dp[i][j], dp[i - 1][j]);
            dp[i][j + blocks[i]] = max(dp[i][j + blocks[i]], dp[i - 1][j] + blocks[i]);

            if (blocks[i] > j) {
                dp[i][blocks[i] - j] = max(dp[i][blocks[i] - j], (blocks[i] - j) + dp[i - 1][j]);
            } else {
                dp[i][j - blocks[i]] = max(dp[i][j - blocks[i]], dp[i - 1][j]);
            }
        }
    }

    int ret = dp[N - 1][0];
    if (ret > half || ret == 0) {
        cout << "-1" << endl;
    } else {
        cout << ret << endl;
    }

    return 0;
}