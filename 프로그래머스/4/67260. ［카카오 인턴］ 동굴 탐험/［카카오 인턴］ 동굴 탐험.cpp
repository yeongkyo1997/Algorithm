#include <vector>
#include <algorithm>

using namespace std;

bool solution(int n, vector<vector<int>> path, vector<vector<int>> order) {
    // Step 1: Build the tree adjacency list
    vector<vector<int>> tree(n);
    for (auto& p : path) {
        int u = p[0];
        int v = p[1];
        tree[u].push_back(v);
        tree[v].push_back(u);
    }
    
    // Step 2: Perform DFS to record entry and exit times
    vector<int> entry(n, 0);
    vector<int> exit(n, 0);
    int time = 0;
    vector<bool> visited(n, false);
    
    function<void(int, int)> dfsEntry = [&](int u, int parent) {
        visited[u] = true;
        entry[u] = time++;
        for (int v : tree[u]) {
            if (v != parent && !visited[v]) {
                dfsEntry(v, u);
            }
        }
        exit[u] = time++;
    };
    
    dfsEntry(0, -1);
    
    // Step 3: Add dependency edges if necessary
    vector<vector<int>> adj(n);
    for (auto& dep : order) {
        int A = dep[0];
        int B = dep[1];
        // Check if A is not an ancestor of B
        if (!(entry[A] <= entry[B] && exit[A] >= exit[B])) {
            adj[A].push_back(B);
        }
    }
    
    // Add tree edges to the adjacency list
    for (int u = 0; u < n; u++) {
        for (int v : tree[u]) {
            if (u != v && entry[u] < entry[v]) { // Add edge from parent to child
                adj[u].push_back(v);
            }
        }
    }
    
    // Step 4: Perform DFS-based cycle detection
    vector<int> visited_cycle(n, 0); // 0: unvisited, 1: visiting, 2: visited
    bool has_cycle = false;
    
    function<void(int)> dfsCycle = [&](int u) {
        visited_cycle[u] = 1;
        for (int v : adj[u]) {
            if (visited_cycle[v] == 0) {
                dfsCycle(v);
                if (has_cycle) return;
            } else if (visited_cycle[v] == 1) {
                has_cycle = true;
                return;
            }
        }
        visited_cycle[u] = 2;
    };
    
    for (int u = 0; u < n; u++) {
        if (visited_cycle[u] == 0) {
            dfsCycle(u);
            if (has_cycle) break;
        }
    }
    
    return !has_cycle;
}