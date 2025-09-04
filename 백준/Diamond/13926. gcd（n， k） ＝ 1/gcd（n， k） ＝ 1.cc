#include <bits/stdc++.h>
using namespace std;

using u64 = unsigned long long;
using u128 = __uint128_t;

u64 mul_mod(u64 a, u64 b, u64 mod) {
    return (u128)a * b % mod;
}

u64 pow_mod(u64 a, u64 d, u64 mod) {
    u64 r = 1;
    while (d) {
        if (d & 1) r = mul_mod(r, a, mod);
        a = mul_mod(a, a, mod);
        d >>= 1;
    }
    return r;
}

bool isPrime(u64 n) {
    if (n < 2) return false;
    for (u64 p : {2ULL,3ULL,5ULL,7ULL,11ULL,13ULL,17ULL}) {
        if (n % p == 0) return n == p;
    }
    u64 d = n - 1, s = 0;
    while ((d & 1) == 0) { d >>= 1; ++s; }
    auto check = [&](u64 a) {
        if (a % n == 0) return true;
        u64 x = pow_mod(a, d, n);
        if (x == 1 || x == n - 1) return true;
        for (u64 i = 1; i < s; ++i) {
            x = mul_mod(x, x, n);
            if (x == n - 1) return true;
        }
        return false;
    };
    for (u64 a : {2ULL,3ULL,5ULL,7ULL,11ULL,13ULL,17ULL}) {
        if (!check(a)) return false;
    }
    return true;
}

u64 rng64() {
    static u64 x = 0x9e3779b97f4a7c15ULL; // splitmix64
    x += 0x9e3779b97f4a7c15ULL;
    u64 z = x;
    z = (z ^ (z >> 30)) * 0xbf58476d1ce4e5b9ULL;
    z = (z ^ (z >> 27)) * 0x94d049bb133111ebULL;
    return z ^ (z >> 31);
}

u64 pollard(u64 n) {
    if ((n & 1ULL) == 0) return 2;
    if (n % 3ULL == 0) return 3;
    while (true) {
        u64 c = (rng64() % (n - 2)) + 1; // [1, n-2]
        u64 x = rng64() % n;
        u64 y = x;
        u64 d = 1;
        auto f = [&](u64 v) { return (mul_mod(v, v, n) + c) % n; };
        while (d == 1) {
            x = f(x);
            y = f(f(y));
            u64 diff = x > y ? x - y : y - x;
            d = std::gcd(diff, n);
        }
        if (d != n) return d;
    }
}

void factor(u64 n, vector<u64>& fac) {
    if (n == 1) return;
    if (isPrime(n)) { fac.push_back(n); return; }
    u64 d = pollard(n);
    factor(d, fac);
    factor(n / d, fac);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    u64 n;
    if (!(cin >> n)) return 0;

    if (n == 1) {
        cout << 1 << '\n';
        return 0;
    }

    vector<u64> fac;
    factor(n, fac);
    sort(fac.begin(), fac.end());
    fac.erase(unique(fac.begin(), fac.end()), fac.end());

    __uint128_t phi = n;
    for (u64 p : fac) {
        phi -= phi / p; // phi = phi * (1 - 1/p)
    }

    cout << (u64)phi << '\n';
    return 0;
}