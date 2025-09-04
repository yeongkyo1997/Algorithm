#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    const long long MOD = 1000000007LL;

    int N;
    if (!(cin >> N)) return 0;

    long long dp = 0, ans = 0;
    for (int i = 0; i < N - 1; ++i) {
        long long x; cin >> x;
        dp = (x % MOD) * ((1 + dp) % MOD) % MOD;
        ans = (ans + dp) % MOD;
    }
    cout << ans << "\n";
    return 0;
}