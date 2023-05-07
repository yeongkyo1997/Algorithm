#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

const int MAX = 1000 + 5;

vector<int> adj[MAX];
bool visited[MAX];

void dfs(int v) {
    visited[v] = true;
    for (int i = 0; i < adj[v].size(); i++) {
        int next = adj[v][i];
        if (!visited[next]) {
            dfs(next);
        }
    }
}

int main() {
    int N, M;
    cin >> N >> M;

    for (int i = 0; i < M; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    int cnt = 0;
    memset(visited, false, sizeof(visited));
    for (int i = 1; i <= N; i++) {
        if (!visited[i]) {
            dfs(i);
            cnt++;
        }
    }

    cout << cnt << endl;

    return 0;
}