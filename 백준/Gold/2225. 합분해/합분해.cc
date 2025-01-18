#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    const int MOD = 1000000000;
    int N, K;
    cin >> N >> K;

    vector<vector<long long>> dp(K + 1, vector<long long>(N + 1, 0LL));

    for (int n = 0; n <= N; n++)
    {
        dp[1][n] = 1;
    }
    for (int k = 1; k <= K; k++)
    {
        dp[k][0] = 1;
    }

    for (int k = 2; k <= K; k++)
    {
        for (int n = 1; n <= N; n++)
        {
            dp[k][n] = (dp[k][n - 1] + dp[k - 1][n]) % MOD;
        }
    }

    cout << dp[K][N] % MOD << '\n';
    return 0;
}