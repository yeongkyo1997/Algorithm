#include <bits/stdc++.h>

using namespace std;

int V, E;
int MAX, res;
vector<vector<int>> c, f, weight;
vector<int> parent;
vector<bool> isInQ;
vector<vector<int>> edges;

void make_edge(int from, int to, int capacity, int cost) {
    edges[from].push_back(to);
    edges[to].push_back(from);

    c[from][to] = capacity;
    weight[from][to] = cost;
    weight[to][from] = -cost;
}

void min_cost_max_flow(int source, int sink) {
    res = 0;
    while (true) {
        parent.assign(MAX, -1);
        isInQ.assign(MAX, false);
        vector<int> cost(MAX, numeric_limits<int>::max());
        cost[source] = 0;

        queue<int> que;
        que.push(source);
        isInQ[source] = true;

        while (!que.empty()) {
            int cur = que.front();
            que.pop();
            isInQ[cur] = false;
            for (int next : edges[cur]) {
                if (c[cur][next] - f[cur][next] > 0 && cost[cur] + weight[cur][next] < cost[next]) {
                    cost[next] = cost[cur] + weight[cur][next];
                    parent[next] = cur;
                    if (!isInQ[next]) {
                        que.push(next);
                        isInQ[next] = true;
                    }
                }
            }
        }

        if (parent[sink] == -1) break;

        for (int i = sink; i != source; i = parent[i]) {
            res += weight[parent[i]][i];
            f[parent[i]][i]++;
            f[i][parent[i]]--;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    while (cin >> V >> E) {
        int source = V * 2 + 2;
        int sink = V * 2 + 3;
        MAX = V * 2 + 4;

        c.assign(MAX, vector<int>(MAX, 0));
        f.assign(MAX, vector<int>(MAX, 0));
        weight.assign(MAX, vector<int>(MAX, 0));
        parent.assign(MAX, 0);
        isInQ.assign(MAX, false);
        edges.assign(MAX, vector<int>());

        make_edge(source, 2, 2, 0);
        make_edge(V * 2 + 1, sink, 2, 0);
        make_edge(2, 3, 2, 0);
        make_edge(V * 2, V * 2 + 1, 2, 0);
        for (int i = 2; i < V; i++) {
            make_edge(i * 2, i * 2 + 1, 1, 0);
        }

        for (int i = 0; i < E; i++) {
            int from, to, cost;
            cin >> from >> to >> cost;
            make_edge(from * 2 + 1, to * 2, 1, cost);
        }

        min_cost_max_flow(source, sink);
        cout << res << endl;
    }

    return 0;
}