#include <iostream>
#include <queue>
#include <vector>

#define endl '\n'

using namespace std;

int n;
int x, y;
vector<int> a[101];
int dist[101];

int bfs() {
    queue<int> q;
    q.push(x);

    while (!q.empty()) {
        int now = q.front();
        q.pop();

        if (now == y) 
            return dist[now];

        for (int i = 0; i < (int)a[now].size(); i++) {
            int next = a[now][i];
            if (dist[next]) 
                continue;

            q.push(next);
            dist[next] = dist[now] + 1;
        }
    }
    return -1;
}

int main() {
    cin >> n;
    cin >> x >> y;
    int m;

    cin >> m;

    for (int i = 0; i < m; i++) {
        int u, v;

        cin >> u >> v;

        a[u].push_back(v);
        a[v].push_back(u);
    }
    cout << bfs() << endl;
    return 0;
}