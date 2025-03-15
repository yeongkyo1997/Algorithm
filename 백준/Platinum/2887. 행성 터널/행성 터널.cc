#include <iostream>
#include <vector>
#include <algorithm>
#include <tuple>

using namespace std;

struct Planet {
    int x, y, z;
    int index;
};

vector<int> parent;

int find(int u) {
    if (parent[u] != u)
        parent[u] = find(parent[u]);
    return parent[u];
}

void unite(int u, int v) {
    u = find(u);
    v = find(v);
    if (u != v)
        parent[v] = u;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    vector<Planet> planets(N);
    for (int i = 0; i < N; ++i) {
        cin >> planets[i].x >> planets[i].y >> planets[i].z;
        planets[i].index = i;
    }

    vector<tuple<int, int, int>> edges;

    sort(planets.begin(), planets.end(), [](const Planet& a, const Planet& b) {
        return a.x < b.x;
    });
    for (int i = 1; i < N; ++i) {
        int cost = abs(planets[i].x - planets[i-1].x);
        edges.emplace_back(cost, planets[i-1].index, planets[i].index);
    }

    sort(planets.begin(), planets.end(), [](const Planet& a, const Planet& b) {
        return a.y < b.y;
    });
    for (int i = 1; i < N; ++i) {
        int cost = abs(planets[i].y - planets[i-1].y);
        edges.emplace_back(cost, planets[i-1].index, planets[i].index);
    }

    sort(planets.begin(), planets.end(), [](const Planet& a, const Planet& b) {
        return a.z < b.z;
    });
    for (int i = 1; i < N; ++i) {
        int cost = abs(planets[i].z - planets[i-1].z);
        edges.emplace_back(cost, planets[i-1].index, planets[i].index);
    }

    sort(edges.begin(), edges.end());

    parent.resize(N);
    for (int i = 0; i < N; ++i)
        parent[i] = i;

    int total = 0;
    for (auto& edge : edges) { // C++11 compatible iteration
        int cost = get<0>(edge);
        int u = get<1>(edge);
        int v = get<2>(edge);
        if (find(u) != find(v)) {
            unite(u, v);
            total += cost;
        }
    }

    cout << total;
    return 0;
}