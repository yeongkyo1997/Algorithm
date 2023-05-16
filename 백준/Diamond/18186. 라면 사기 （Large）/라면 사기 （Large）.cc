#include <bits/stdc++.h>


using namespace std;

int main() {
    int N, B, C;
    cin >> N >> B >> C;

    vector<int> seq(2, 0);
    for (int i = 0; i < N; ++i) {
        int x;
        cin >> x;
        seq.push_back(x);
    }

    if (C >= B) {
        cout << accumulate(seq.begin(), seq.end(), 0LL) * B << endl;
    } else {
        vector<vector<int>> dp(3, vector<int>(N + 2, 0));
        for (int i = 2; i < N + 2; ++i) {
            int x = seq[i];
            dp[1][i] = min(x, dp[0][i - 1]);
            x -= dp[1][i];
            dp[0][i - 1] -= dp[1][i];
            dp[2][i] = min(x, dp[1][i - 1]);
            x -= dp[2][i];
            dp[1][i - 1] -= dp[2][i];
            dp[0][i] = x;
        }
        cout << accumulate(dp[0].begin(), dp[0].end(), 0LL) * B +
                    accumulate(dp[1].begin(), dp[1].end(), 0LL) * (B + C) +
                    accumulate(dp[2].begin(), dp[2].end(), 0LL) * (B + C * 2) << endl;
    }

    return 0;
}