#include <bits/stdc++.h>
using namespace std;

// Pair to store F(n) and F(n+1)
typedef pair<long long, long long> pii;

// Fast doubling method to compute F(n) and F(n+1)
pii fib(long long n) {
    if (n == 0)
        return {0, 1};
    pii p = fib(n / 2);
    long long c = (p.first * ((2 * p.second % 1000000 + 1000000 - p.first) % 1000000)) % 1000000;
    long long d = (p.first * p.first % 1000000 + p.second * p.second % 1000000) % 1000000;
    if (n % 2 == 0)
        return {c, d};
    else
        return {d, (c + d) % 1000000};
}

int main(){
    long long n;
    cin >> n;
    pii result = fib(n);
    cout << result.first;
}