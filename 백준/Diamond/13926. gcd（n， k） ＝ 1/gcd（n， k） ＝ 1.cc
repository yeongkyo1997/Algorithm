#include <bits/stdc++.h>

using namespace std;
typedef unsigned long long ull;

ull mulmod(ull a, ull b, ull mod)
{
    __int128 res = (__int128(a) * b) % mod;
    return res;
}

ull powmod(ull base, ull exponent, ull mod)
{
    ull res = 1;
    base %= mod;
    while (exponent > 0)
    {
        if (exponent & 1)
        {
            res = mulmod(res, base, mod);
        }
        base = mulmod(base, base, mod);
        exponent >>= 1;
    }
    return res;
}

ull gcd(ull a, ull b)
{
    return (b == 0) ? a : gcd(b, a % b);
}

bool is_prime(ull n)
{
    if (n < 2)
        return false;

    static const ull bases[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};

    ull d = n - 1;
    int s = 0;
    while (d % 2 == 0)
    {
        d /= 2;
        s++;
    }
    for (auto a : bases)
    {
        if (a >= n)
            continue;
        ull x = powmod(a, d, n);
        if (x == 1 || x == n - 1)
            continue;
        bool cont_outer = false;
        for (int r = 1; r < s; r++)
        {
            x = mulmod(x, x, n);
            if (x == n - 1)
            {
                cont_outer = true;
                break;
            }
        }
        if (cont_outer)
            continue;
        return false;
    }
    return true;
}

mt19937_64 mt_rand64(chrono::steady_clock::now().time_since_epoch().count());

ull pollards_rho(ull n)
{
    if (n % 2 == 0)
        return 2;
    if (n % 3 == 0)
        return 3;
    if (n % 5 == 0)
        return 5;
    if (n % 7 == 0)
        return 7;
    if (n % 11 == 0)
        return 11;
    if (n % 13 == 0)
        return 13;
    if (n % 17 == 0)
        return 17;
    if (n % 19 == 0)
        return 19;
    if (n % 23 == 0)
        return 23;
    if (n % 29 == 0)
        return 29;
    if (n % 31 == 0)
        return 31;
    if (n % 37 == 0)
        return 37;
    if (is_prime(n))
        return n;
    while (true)
    {
        ull c = mt_rand64() % n;
        auto f = [&](ull x) -> ull
        {
            return (mulmod(x, x, n) + c) % n;
        };
        ull x = 2, y = 2, d = 1;
        while (d == 1)
        {
            x = f(x);
            y = f(f(y));
            d = gcd((x > y) ? x - y : y - x, n);
        }
        if (d != n)
        {
            if (is_prime(d))
                return d;
            else
                return pollards_rho(d);
        }
    }
}

void factor(ull n, vector<ull> &factors)
{
    if (n == 1)
        return;
    if (is_prime(n))
    {
        factors.push_back(n);
        return;
    }
    ull d = pollards_rho(n);
    factor(d, factors);
    factor(n / d, factors);
}

ull compute_phi(ull n)
{
    if (n == 1)
        return 1;
    vector<ull> factors;
    factor(n, factors);

    vector<ull> unique_factors;
    sort(factors.begin(), factors.end());
    factors.erase(unique(factors.begin(), factors.end()), factors.end());

    double phi = n;
    for (auto p : factors)
    {
        phi *= (1.0 - 1.0 / (double)p);
    }

    ull result = n;
    for (auto p : factors)
    {
        result -= result / p;
    }
    return result;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    ull n;
    cin >> n;
    ull phi_n = compute_phi(n);
    cout << phi_n;
}