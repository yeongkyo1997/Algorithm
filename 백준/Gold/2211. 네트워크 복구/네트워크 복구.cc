#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M;
    if (!(cin >> N >> M)) return 0;

    vector<vector<pair<int,int>>> adj(N + 1);
    for (int i = 0; i < M; ++i) {
        int a, b, c; cin >> a >> b >> c;
        adj[a].push_back({b, c});
        adj[b].push_back({a, c});
    }

    const long long INF = 4e18;
    vector<long long> dist(N + 1, INF);
    vector<int> parent(N + 1, 0);

    priority_queue<pair<long long,int>, vector<pair<long long,int>>, greater<pair<long long,int>>> pq;
    dist[1] = 0;
    pq.push({0, 1});

    while (!pq.empty()) {
        auto [d, u] = pq.top(); pq.pop();
        if (d != dist[u]) continue;
        for (auto [v, w] : adj[u]) {
            long long nd = d + w;
            if (dist[v] > nd) {
                dist[v] = nd;
                parent[v] = u;
                pq.push({nd, v});
            }
        }
    }

    cout << N - 1 << "\n";
    for (int i = 2; i <= N; ++i) {
        cout << parent[i] << ' ' << i << "\n";
    }
    return 0;
}