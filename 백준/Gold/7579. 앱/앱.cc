#include <bits/stdc++.h>

using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    vector<int> memories(n);
    vector<int> cost(n);

    for (int i = 0; i < n; i++) {
        cin >> memories[i];
    }

    for (int i = 0; i < n; i++) {
        cin >> cost[i];
    }

    int sol = 100 * 100;
    int max_cost = accumulate(cost.begin(), cost.end(), 0) + 1;
    vector<vector<int>> dp(n + 1, vector<int>(max_cost, 0));

    if (m == 0) {
        cout << 0 << endl;
    } else {
        for (int i = 1; i <= n; i++) {
            int byte = memories[i - 1];
            int c = cost[i - 1];

            for (int j = 1; j < max_cost; j++) {
                if (j < c) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = max(byte + dp[i - 1][j - c], dp[i - 1][j]);
                }

                if (dp[i][j] >= m) {
                    sol = min(sol, j);
                }
            }
        }
        cout << sol << endl;
    }

    return 0;
}