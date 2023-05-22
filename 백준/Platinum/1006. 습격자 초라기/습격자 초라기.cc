#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <limits>

using namespace std;

const int INF = 123456789;
enum dp_type { top = 0, bottom, both };

void solve(vector<vector<int>>& dp, const vector<vector<int>>& enemy, int n, int w) {
    for (int i = 2; i <= n / 2; i++) {
        dp[top][i] = dp[both][i - 1] + 1;
        if (enemy[top][i - 1] + enemy[top][i] <= w)
            dp[top][i] = min(dp[bottom][i - 1] + 1, dp[top][i]);

        dp[bottom][i] = dp[both][i - 1] + 1;
        if (enemy[bottom][i - 1] + enemy[bottom][i] <= w)
            dp[bottom][i] = min(dp[top][i - 1] + 1, dp[bottom][i]);

        dp[both][i] = min(dp[top][i] + 1, dp[bottom][i] + 1);
        if (enemy[top][i] + enemy[bottom][i] <= w)
            dp[both][i] = min(dp[both][i - 1] + 1, dp[both][i]);
        if (enemy[top][i - 1] + enemy[top][i] <= w && enemy[bottom][i - 1] + enemy[bottom][i] <= w)
            dp[both][i] = min(dp[both][i - 2] + 2, dp[both][i]);
    }
}

int main() {
    int t;
    cin >> t;

    for (int caseNum = 0; caseNum < t; caseNum++) {
        int n, w;
        cin >> n >> w;
        n *= 2;
        vector<vector<int>> enemy(2, vector<int>(n / 2 + 1));

        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= n / 2; j++) {
                cin >> enemy[i][j];
            }
        }

        if (n == 2) {
            int ret = enemy[top][1] + enemy[bottom][1] <= w ? 1 : 2;
            cout << ret << endl;
            continue;
        }

        int ret = INF;
        vector<vector<int>> dp(3, vector<int>(n / 2 + 1, 0));

        dp[top][1] = 1; dp[bottom][1] = 1;
        dp[both][1] = enemy[top][1] + enemy[bottom][1] <= w ? 1 : 2;
        solve(dp, enemy, n, w);
        ret = min(ret, dp[both][n / 2]);

        if (enemy[top][1] + enemy[top][n / 2] <= w) {
            fill(dp.begin(), dp.end(), vector<int>(n / 2 + 1, 0));
            dp[top][1] = 1; dp[bottom][1] = INF;
            dp[both][1] = 2;
            dp[both][0] = INF;
            solve(dp, enemy, n, w);
            ret = min(ret, dp[bottom][n / 2]);
        }

        if (enemy[bottom][1] + enemy[bottom][n / 2] <= w) {
            fill(dp.begin(), dp.end(), vector<int>(n / 2 + 1, 0));
            dp[bottom][1] = 1; dp[top][1] = INF;
            dp[both][1] = 2;
            dp[both][0] = INF;
            solve(dp, enemy, n, w);
            ret = min(ret, dp[top][n / 2]);
        }

        if (enemy[top][1] + enemy[top][n / 2] <= w && enemy[bottom][1] + enemy[bottom][n / 2] <= w) {
            fill(dp.begin(), dp.end(), vector<int>(n / 2 + 1, 0));
            dp[top][1] = INF; dp[bottom][1] = INF;
            dp[both][1] = 2;
            dp[both][0] = INF;
            solve(dp, enemy, n, w);
            ret = min(ret, dp[both][n / 2 - 1]);
        }

        cout << ret << endl;
    }

    return 0;
}