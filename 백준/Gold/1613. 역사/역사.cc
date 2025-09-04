#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    if (!(cin >> n >> k)) return 0;

    vector<bitset<401>> reach(n + 1); // reach[i][j] == 1 if i -> j
    for (int i = 0; i < k; ++i) {
        int a, b; cin >> a >> b;
        reach[a].set(b);
    }

    // Transitive closure: if i -> mid then i -> all mid's successors
    for (int mid = 1; mid <= n; ++mid) {
        for (int i = 1; i <= n; ++i) {
            if (reach[i].test(mid)) {
                reach[i] |= reach[mid];
            }
        }
    }

    int s; cin >> s;
    while (s--) {
        int a, b; cin >> a >> b;
        if (reach[a].test(b)) cout << -1 << '\n';
        else if (reach[b].test(a)) cout << 1 << '\n';
        else cout << 0 << '\n';
    }
    return 0;
}