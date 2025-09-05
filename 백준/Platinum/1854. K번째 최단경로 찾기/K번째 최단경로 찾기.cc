#include <bits/stdc++.h>
using namespace std;

using ll = long long;
using pli = pair<ll,int>;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m, k;
    if (!(cin >> n >> m >> k)) return 0;

    vector<vector<pair<int,int>>> g(n + 1);
    for (int i = 0; i < m; ++i) {
        int a, b, c;
        cin >> a >> b >> c;
        g[a].push_back({b, c}); // 유향 그래프
    }

    // 각 정점별로 "작은 거리 k개"를 담는 최대 힙
    vector<priority_queue<ll>> dist(n + 1);

    // 전체 탐색을 위한 최소 힙 (거리, 정점)
    priority_queue<pli, vector<pli>, greater<pli>> pq;

    dist[1].push(0);
    pq.emplace(0, 1);

    while (!pq.empty()) {
        auto [d, u] = pq.top(); pq.pop();

        // u에 대해 현재 보관 중인 k번째 거리보다 더 크면 더 볼 필요 없음
        if ((int)dist[u].size() == k && dist[u].top() < d) continue;

        for (auto [v, w] : g[u]) {
            ll nd = d + w;

            if ((int)dist[v].size() < k) {
                dist[v].push(nd);
                pq.emplace(nd, v);
            } else if (dist[v].top() > nd) {
                dist[v].pop();
                dist[v].push(nd);
                pq.emplace(nd, v);
            }
        }
    }

    for (int i = 1; i <= n; ++i) {
        if ((int)dist[i].size() < k) cout << -1 << '\n';
        else cout << dist[i].top() << '\n'; // k번째 최단거리
    }

    return 0;
}