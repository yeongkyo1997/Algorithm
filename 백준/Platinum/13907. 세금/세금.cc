#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M, K;
    if (!(cin >> N >> M >> K)) return 0;

    int S, D;
    cin >> S >> D;

    vector<vector<pair<int,int>>> adj(N+1);
    adj.reserve(N+1);
    for (int i = 0; i < M; ++i) {
        int a, b, w; cin >> a >> b >> w;
        adj[a].push_back({b, w});
        adj[b].push_back({a, w});
    }

    vector<long long> taxes(K);
    for (int i = 0; i < K; ++i) cin >> taxes[i];

    const long long INF = (1LL<<60);

    // DP: exact-edge shortest paths
    vector<long long> prev(N+1, INF), cur(N+1, INF);
    vector<long long> distD(N+1, INF);
    prev[S] = 0;

    for (int e = 1; e <= N; ++e) {
        fill(cur.begin(), cur.end(), INF);
        for (int u = 1; u <= N; ++u) {
            long long du = prev[u];
            if (du == INF) continue;
            for (auto [v, w] : adj[u]) {
                long long nv = du + w;
                if (nv < cur[v]) cur[v] = nv;
            }
        }
        distD[e] = cur[D];
        prev.swap(cur);
    }

    auto best0 = *min_element(distD.begin()+1, distD.end());
    cout << best0 << '\n';

    long long T = 0;
    for (int i = 0; i < K; ++i) {
        T += taxes[i];
        long long ans = INF;
        for (int e = 1; e <= N; ++e) {
            if (distD[e] == INF) continue;
            ans = min(ans, distD[e] + (long long)e * T);
        }
        cout << ans << '\n';
    }
    return 0;
}