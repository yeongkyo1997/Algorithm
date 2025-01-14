#include <bits/stdc++.h>
using namespace std;

static const int INF = 1e9;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M;
    cin >> N >> M;

    vector<bool> isPho(N, false);
    for (int i = 0; i < M; i++)
    {
        int x;
        cin >> x;
        isPho[x] = true;
    }

    vector<vector<int>> adj(N);
    for (int i = 0; i < N - 1; i++)
    {
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    queue<int> q;
    vector<int> degree(N, 0);

    for (int i = 0; i < N; i++)
    {
        degree[i] = (int)adj[i].size();
    }

    for (int i = 0; i < N; i++)
    {
        if (!isPho[i] && degree[i] == 1)
        {
            q.push(i);
        }
    }

    while (!q.empty())
    {
        int leaf = q.front();
        q.pop();

        if (degree[leaf] == 0)
            continue;

        degree[leaf] = 0;

        for (auto &nxt : adj[leaf])
        {
            if (degree[nxt] > 0)
            {
                degree[nxt]--;
                if (!isPho[nxt] && degree[nxt] == 1)
                {
                    q.push(nxt);
                }
            }
        }
    }

    int start = 0;
    for (int i = 0; i < N; i++)
    {
        if (degree[i] > 0 && isPho[i])
        {
            start = i;
            break;
        }
    }

    auto bfs = [&](int s)
    {
        vector<int> dist(N, INF);
        queue<int> qu;
        dist[s] = 0;
        qu.push(s);
        int farNode = s;

        while (!qu.empty())
        {
            int cur = qu.front();
            qu.pop();
            for (auto &nx : adj[cur])
            {

                if (degree[nx] == 0)
                    continue;
                if (dist[nx] > dist[cur] + 1)
                {
                    dist[nx] = dist[cur] + 1;
                    qu.push(nx);
                    if (dist[nx] > dist[farNode])
                    {
                        farNode = nx;
                    }
                }
            }
        }
        return make_pair(farNode, dist[farNode]);
    };

    auto p1 = bfs(start);
    int X = p1.first;

    auto p2 = bfs(X);
    int Y = p2.first;
    int diameter = p2.second;

    long long remainEdges = 0;
    for (int i = 0; i < N; i++)
    {
        remainEdges += degree[i];
    }
    remainEdges /= 2;

    long long ans = 2LL * remainEdges - diameter;
    cout << ans << "\n";

    return 0;
}