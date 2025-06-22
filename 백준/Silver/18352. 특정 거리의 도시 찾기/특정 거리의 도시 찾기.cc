#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    int n, m, k, x;
    std::cin >> n >> m >> k >> x;

    std::vector<std::vector<int>> adj(n + 1);
    for (int i = 0; i < m; ++i) {
        int u, v;
        std::cin >> u >> v;
        adj[u].push_back(v);
    }

    std::vector<int> dist(n + 1, -1);
    std::queue<int> q;

    q.push(x);
    dist[x] = 0;

    while (!q.empty()) {
        int current_city = q.front();
        q.pop();

        for (int neighbor : adj[current_city]) {
            if (dist[neighbor] == -1) {
                dist[neighbor] = dist[current_city] + 1;
                q.push(neighbor);
            }
        }
    }

    std::vector<int> result_cities;
    for (int i = 1; i <= n; ++i) {
        if (dist[i] == k) {
            result_cities.push_back(i);
        }
    }

    if (result_cities.empty()) {
        std::cout << -1 << std::endl;
    } else {
        for (int city : result_cities) {
            std::cout << city << "\n";
        }
    }

    return 0;
}