#include <iostream>
#include <vector>
#include <queue>
#include <limits>

using namespace std;

const int INF = numeric_limits<int>::max();

int N, M;
vector<vector<pair<int, int>>> adj;

int dijkstra(int start, int end) {
    vector<int> dist(N + 1, INF);
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

    dist[start] = 0;
    pq.push({0, start});

    while (!pq.empty()) {
        int d = pq.top().first;
        int cur = pq.top().second;
        pq.pop();

        if (d > dist[cur]) continue;

        for (const auto &next : adj[cur]) {
            int nd = d + next.second;
            int nx = next.first;

            if (nd < dist[nx]) {
                dist[nx] = nd;
                pq.push({nd, nx});
            }
        }
    }

    return dist[end];
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    cin >> N >> M;

    adj.resize(N + 1);
    for (int i = 0; i < M; ++i) {
        int a, b, c;
        cin >> a >> b >> c;
        adj[a].push_back({b, c});
    }

    int start, end;
    cin >> start >> end;

    cout << dijkstra(start, end) << '\n';

    return 0;
}