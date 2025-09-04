#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    if (!(cin >> T)) return 0;

    while (T--) {
        int N, K;
        cin >> N >> K;
        long long ans = 0;
        for (int i = 0; i < N; ++i) {
            int c;
            cin >> c;
            ans += c / K;
        }
        cout << ans << '\n';
    }
    return 0;
}