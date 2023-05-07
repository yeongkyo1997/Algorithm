#include <iostream>
#include <vector>
#include <queue>
using namespace std;

const int MAX = 100;

vector<int> adj[MAX + 1];
bool visited[MAX + 1];

int BFS(int start) {
    queue<int> q;
    int cnt = 0;

    q.push(start);
    visited[start] = true;

    while (!q.empty()) {
        int cur = q.front();
        q.pop();
        cnt++;

        for (int i = 0; i < adj[cur].size(); i++) {
            int next = adj[cur][i];

            if (!visited[next]) {
                visited[next] = true;
                q.push(next);
            }
        }
    }

    return cnt;
}

int main() {
    int n, m;
    cin >> n >> m;

    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    cout << BFS(1) - 1 << endl;

    return 0;
}