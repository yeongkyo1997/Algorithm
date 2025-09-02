#include <bits/stdc++.h>
using namespace std;

long long solve_case(const vector<int>& cur, const vector<int>& tgt, bool first_pressed) {
    const long long INF = (long long)4e18;
    int n = (int)cur.size();
    vector<int> a = cur;
    long long cnt = 0;

    if (first_pressed) {
        cnt++;
        a[0] ^= 1;
        if (n > 1) a[1] ^= 1;
    }

    for (int i = 1; i < n; ++i) {
        if (a[i-1] != tgt[i-1]) {
            cnt++;
            a[i-1] ^= 1;
            a[i] ^= 1;
            if (i + 1 < n) a[i+1] ^= 1;
        }
    }
    return (a[n-1] == tgt[n-1]) ? cnt : INF;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n;
    if (!(cin >> n)) return 0;
    string s, t;
    cin >> s >> t;

    vector<int> cur(n), tgt(n);
    for (int i = 0; i < n; ++i) cur[i] = s[i] - '0';
    for (int i = 0; i < n; ++i) tgt[i] = t[i] - '0';

    long long a = solve_case(cur, tgt, false);
    long long b = solve_case(cur, tgt, true);
    long long ans = min(a, b);
    cout << (ans >= (long long)4e18 ? -1 : ans) << '\n';
    return 0;
}