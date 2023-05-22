#include <iostream>
#include <vector>
using namespace std;

bool dfs(int cur, vector<int> &visit, vector<vector<int>> &graph, vector<int> &b) {
    visit[cur] = 1;
    for (int nxt : graph[cur]) {
        if (b[nxt] == -1 || (!visit[b[nxt]] && dfs(b[nxt], visit, graph, b))) {
            b[nxt] = cur;
            return 1;
        }
    }
    return 0;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        vector<vector<int>> graph(n);

        for (int i = 0; i < m; i++) {
            int u, v;
            cin >> u >> v;
            graph[u].push_back(v);
        }

        vector<int> b(n, -1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            vector<int> visit(n, 0);
            ans += dfs(i, visit, graph, b);
        }

        cout << ans << '\n';
    }

    return 0;
}