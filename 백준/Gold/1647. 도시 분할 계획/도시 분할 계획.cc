#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Edge {
    int a, b, c;
    Edge(int a, int b, int c) : a(a), b(b), c(c) {}
    bool operator<(const Edge& other) const {
        return c < other.c;
    }
};

vector<Edge> edges;
int parent[100001];

int find(int x) {
    if (parent[x] == x) return x;
    return parent[x] = find(parent[x]);
}

void union_set(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b) {
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M;
    cin >> N >> M;

    for (int i = 0; i < M; ++i) {
        int a, b, c;
        cin >> a >> b >> c;
        edges.emplace_back(a, b, c);
    }

    sort(edges.begin(), edges.end());
    for (int i = 1; i <= N; ++i) parent[i] = i;

    int total = 0, max_edge = 0, cnt = 0;
    for (auto& e : edges) {
        if (find(e.a) != find(e.b)) {
            union_set(e.a, e.b);
            total += e.c;
            max_edge = max(max_edge, e.c);
            if (++cnt == N - 1) break;
        }
    }

    cout << total - max_edge;
    return 0;
}