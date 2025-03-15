#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Edge {
    int u, v, w;
};

int parent[10001];
int ranks[10001];

int find(int u) {
    if (parent[u] != u)
        parent[u] = find(parent[u]);
    return parent[u];
}

void unite(int u, int v) {
    u = find(u);
    v = find(v);
    if (u != v) {
        if (ranks[u] < ranks[v])
            parent[u] = v;
        else {
            parent[v] = u;
            if (ranks[u] == ranks[v])
                ranks[u]++;
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    int V, E;
    cin >> V >> E;
    
    vector<Edge> edges(E);
    for (auto& e : edges)
        cin >> e.u >> e.v >> e.w;
    
    sort(edges.begin(), edges.end(), [](const Edge& a, const Edge& b) {
        return a.w < b.w;
    });
    
    for (int i = 1; i <= V; i++) {
        parent[i] = i;
        ranks[i] = 1;
    }
    
    int total = 0, cnt = 0;
    for (const auto& e : edges) {
        if (find(e.u) != find(e.v)) {
            unite(e.u, e.v);
            total += e.w;
            if (++cnt == V-1) break;
        }
    }
    
    cout << total;
}