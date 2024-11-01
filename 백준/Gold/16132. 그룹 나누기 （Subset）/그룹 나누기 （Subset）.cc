#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int main()
{
    int N;
    cin >> N;
    ll total_sum = (ll)N * (N + 1) / 2;
    if (total_sum % 2 != 0)
    {
        cout << "0\n";
        return 0;
    }
    ll target = total_sum / 2;
    vector<ll> dp(target + 1, 0);
    dp[0] = 1;
    for (int i = 1; i <= N; ++i)
    {
        for (ll s = target; s >= i; --s)
        {
            dp[s] += dp[s - i];
        }
    }
    cout << dp[target] / 2 << "\n";
}