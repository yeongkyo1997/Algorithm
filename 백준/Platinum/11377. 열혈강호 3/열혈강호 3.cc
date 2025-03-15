#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

struct Edge {
    int to, rev, cap;
    Edge(int t, int r, int c) : to(t), rev(r), cap(c) {}
};

const int MAX = 2005;
vector<Edge> adj[MAX];
int level[MAX], ptr[MAX];
int S = 0, T;

void addEdge(int u, int v, int cap) {
    adj[u].emplace_back(v, adj[v].size(), cap);
    adj[v].emplace_back(u, adj[u].size()-1, 0);
}

bool bfs() {
    memset(level, -1, sizeof(level));
    queue<int> q;
    level[S] = 0;
    q.push(S);
    while (!q.empty()) {
        int u = q.front(); q.pop();
        for (Edge &e : adj[u]) {
            if (e.cap > 0 && level[e.to] == -1) {
                level[e.to] = level[u] + 1;
                q.push(e.to);
                if (e.to == T) return true;
            }
        }
    }
    return false;
}

int dfs(int u, int flow) {
    if (u == T) return flow;
    for (; ptr[u] < adj[u].size(); ptr[u]++) {
        Edge &e = adj[u][ptr[u]];
        if (e.cap > 0 && level[e.to] == level[u] + 1) {
            int res = dfs(e.to, min(flow, e.cap));
            if (res > 0) {
                e.cap -= res;
                adj[e.to][e.rev].cap += res;
                return res;
            }
        }
    }
    return 0;
}

int maxFlow() {
    int total = 0;
    while (bfs()) {
        memset(ptr, 0, sizeof(ptr));
        while (int f = dfs(S, 1e9)) {
            total += f;
        }
    }
    return total;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N, M, K;
    cin >> N >> M >> K;
    T = N + M + 2; 
    
    addEdge(S, 1, K);
    
    for (int i = 0; i < N; ++i) {
        int empNode = 2 + i;
        addEdge(S, empNode, 1);
        addEdge(1, empNode, 1);
        
        int cnt;
        cin >> cnt;
        while (cnt--) {
            int task;
            cin >> task;
            int taskNode = N + 1 + task; 
            addEdge(empNode, taskNode, 1);
        }
    }
    
    for (int task = 1; task <= M; ++task) {
        int taskNode = N + 1 + task;
        addEdge(taskNode, T, 1);
    }
    
    cout << maxFlow() << endl;
    
    return 0;
}