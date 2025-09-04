#include <bits/stdc++.h>
using namespace std;

using u64 = unsigned long long;
using u128 = __uint128_t;

// (a * b) % mod with 128-bit to avoid overflow
static inline u64 mul_mod(u64 a, u64 b, u64 mod) {
    return (u128)a * b % mod;
}

static inline u64 pow_mod(u64 a, u64 d, u64 mod) {
    u64 r = 1;
    while (d) {
        if (d & 1) r = mul_mod(r, a, mod);
        a = mul_mod(a, a, mod);
        d >>= 1;
    }
    return r;
}

// Deterministic Miller–Rabin for 64-bit using known bases
static bool isPrime(u64 n) {
    if (n < 2) return false;
    // small primes check
    for (u64 p : {2ULL, 3ULL, 5ULL, 7ULL, 11ULL, 13ULL, 17ULL, 19ULL, 23ULL, 29ULL, 31ULL, 37ULL}) {
        if (n % p == 0) return n == p;
    }
    // write n-1 = d * 2^s
    u64 d = n - 1, s = 0;
    while ((d & 1) == 0) { d >>= 1; ++s; }

    auto witness = [&](u64 a) -> bool {
        if (a % n == 0) return true;
        u64 x = pow_mod(a, d, n);
        if (x == 1 || x == n - 1) return true;
        for (u64 i = 1; i < s; ++i) {
            x = mul_mod(x, x, n);
            if (x == n - 1) return true;
        }
        return false;
    };

    // Deterministic bases for 64-bit integers
    for (u64 a : {2ULL, 325ULL, 9375ULL, 28178ULL, 450775ULL, 9780504ULL, 1795265022ULL}) {
        if (!witness(a)) return false;
    }
    return true;
}

static u64 pollards_rho(u64 n) {
    if ((n & 1ULL) == 0) return 2;
    static mt19937_64 rng((uint64_t)chrono::steady_clock::now().time_since_epoch().count());
    uniform_int_distribution<u64> dist(2, n - 2);

    while (true) {
        u64 c = dist(rng);
        u64 x = dist(rng);
        u64 y = x;
        u64 d = 1;

        auto f = [&](u64 v) { return (mul_mod(v, v, n) + c) % n; };

        while (d == 1) {
            x = f(x);
            y = f(f(y));
            u64 diff = x > y ? x - y : y - x;
            d = std::gcd(diff, n);
            if (d == n) break;
        }
        if (d > 1 && d < n) return d; // non-trivial factor found
        // else retry with new c/x/y
    }
}

static void factor(u64 n, vector<u64> &fac) {
    if (n == 1) return;
    if (isPrime(n)) {
        fac.push_back(n);
        return;
    }
    u64 d = n;
    while (d == n) d = pollards_rho(n);
    factor(d, fac);
    factor(n / d, fac);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    u64 n;
    if (!(cin >> n)) return 0;

    vector<u64> fac;
    factor(n, fac);
    sort(fac.begin(), fac.end());
    for (u64 p : fac) cout << p << '\n';
    return 0;
}