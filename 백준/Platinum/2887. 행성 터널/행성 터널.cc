#include <iostream>
#include <vector>
#include <algorithm>
#include <tuple>
#include <cmath>
using namespace std;

int find_parent(vector<int>& parent, int x) {
    if (parent[x] != x) {
        parent[x] = find_parent(parent, parent[x]);
    }
    return parent[x];
}

void union_parent(vector<int>& parent, int a, int b) {
    a = find_parent(parent, a);
    b = find_parent(parent, b);
    if (a < b) parent[b] = a;
    else parent[a] = b;
}

int main() {
    int n;
    cin >> n;

    vector<tuple<int, int, int, int>> graph(n);
    for (int i = 0; i < n; ++i) {
        int x, y, z;
        cin >> x >> y >> z;
        graph[i] = make_tuple(x, y, z, i);
    }

    auto x = graph;
    auto y = graph;
    auto z = graph;

    sort(x.begin(), x.end(), [](const auto& a, const auto& b) { return get<0>(a) < get<0>(b); });
    sort(y.begin(), y.end(), [](const auto& a, const auto& b) { return get<1>(a) < get<1>(b); });
    sort(z.begin(), z.end(), [](const auto& a, const auto& b) { return get<2>(a) < get<2>(b); });

    vector<tuple<int, int, int>> edges;
    for (int i = 0; i < n - 1; ++i) {
        edges.emplace_back(abs(get<0>(x[i + 1]) - get<0>(x[i])), get<3>(x[i]), get<3>(x[i + 1]));
        edges.emplace_back(abs(get<1>(y[i + 1]) - get<1>(y[i])), get<3>(y[i]), get<3>(y[i + 1]));
        edges.emplace_back(abs(get<2>(z[i + 1]) - get<2>(z[i])), get<3>(z[i]), get<3>(z[i + 1]));
    }

    sort(edges.begin(), edges.end());

    vector<int> parent(n);
    for (int i = 0; i < n; ++i) {
        parent[i] = i;
    }

    int answer = 0;
    for (const auto& edge : edges) {
        int dist, a, b;
        tie(dist, a, b) = edge;
        if (find_parent(parent, a) != find_parent(parent, b)) {
            union_parent(parent, a, b);
            answer += dist;
        }
    }

    cout << answer << endl;

    return 0;
}