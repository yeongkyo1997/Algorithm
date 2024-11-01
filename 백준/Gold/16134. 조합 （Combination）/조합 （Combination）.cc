#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

const int MOD = 1000000007;
const int MAX = 1000000;

ll power_mod(ll a, ll b, ll mod)
{
    ll res = 1;
    a %= mod;
    while (b > 0)
    {
        if (b & 1)
        {
            res = res * a % mod;
        }
        a = a * a % mod;
        b >>= 1;
    }
    return res;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);

    vector<ll> fact(MAX + 1, 1);
    vector<ll> inv_fact(MAX + 1, 1);

    for (int i = 1; i <= MAX; ++i)
    {
        fact[i] = fact[i - 1] * i % MOD;
    }

    inv_fact[MAX] = power_mod(fact[MAX], MOD - 2, MOD);
    for (int i = MAX - 1; i >= 0; --i)
    {
        inv_fact[i] = inv_fact[i + 1] * (i + 1) % MOD;
    }

    int N, R;
    cin >> N >> R;

    if (R < 0 || R > N)
    {
        cout << "0\n";
        return 0;
    }

    ll result = fact[N] * inv_fact[R] % MOD;
    result = result * inv_fact[N - R] % MOD;

    cout << result << "\n";
}