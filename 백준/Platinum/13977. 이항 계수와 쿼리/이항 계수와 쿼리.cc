#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

const int MOD = 1e9 + 7;

ll power_mod(ll a, ll b, ll mod)
{
    ll ret = 1;
    a %= mod;
    while (b > 0)
    {
        if (b & 1)
        {
            ret = ret * a % mod;
        }
        a = a * a % mod;
        b >>= 1;
    }
    return ret;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int M;
    cin >> M;

    vector<pair<int, int>> queries(M);

    int N, K;
    int maxN = 0;

    for (int i = 0; i < M; i++)
    {
        cin >> N >> K;
        queries[i] = {N, K};
        if (N > maxN)
        {
            maxN = N;
        }
    }

    vector<long long> fact(maxN + 1, 1);

    for (int i = 1; i <= maxN; i++)
    {
        fact[i] = fact[i - 1] * i % MOD;
    }

    vector<long long> inv_fact(maxN + 1, 1);

    inv_fact[maxN] = power_mod(fact[maxN], MOD - 2, MOD);
    for (int i = maxN - 1; i >= 0; i--)
    {
        inv_fact[i] = inv_fact[i + 1] * (i + 1) % MOD;
    }

    for (int i = 0; i < M; i++)
    {
        N = queries[i].first;
        K = queries[i].second;
        if (K < 0 || K > N)
        {
            cout << "0\n";
            continue;
        }
        ll result = fact[N];
        result = result * inv_fact[K] % MOD;
        result = result * inv_fact[N - K] % MOD;
        cout << result << "\n";
    }
}