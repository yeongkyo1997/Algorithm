#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int N; 
    if (!(cin >> N)) return 0;

    vector<int> L(N+1, -1), R(N+1, -1), parent(N+1, 0);
    for (int i = 0; i < N; ++i) {
        int a, l, r; cin >> a >> l >> r;
        L[a] = l; R[a] = r;
        if (l != -1) parent[l] = a;
        if (r != -1) parent[r] = a;
    }

    int root = 1;
    for (int i = 1; i <= N; ++i) if (parent[i] == 0) { root = i; break; }

    const int INF = 1e9;
    vector<int> min_col(N+2, INF), max_col(N+2, 0);

    // 반복 중위순회로 열 번호 부여
    int pos = 1;
    vector<pair<int,int>> st; // (node, depth)
    int cur = root, depth = 1;
    while (cur != -1 || !st.empty()) {
        while (cur != -1) {
            st.push_back({cur, depth});
            cur = L[cur];
            depth++;
        }
        auto [u, d] = st.back(); st.pop_back();
        min_col[d] = min(min_col[d], pos);
        max_col[d] = max(max_col[d], pos);
        pos++;
        cur = R[u];
        depth = d + 1;
    }

    int best_level = 1, best_width = 0;
    for (int d = 1; d <= N; ++d) {
        if (min_col[d] != INF) {
            int width = max_col[d] - min_col[d] + 1;
            if (width > best_width) {
                best_width = width;
                best_level = d;
            }
        }
    }
    cout << best_level << ' ' << best_width << '\n';
    return 0;
}