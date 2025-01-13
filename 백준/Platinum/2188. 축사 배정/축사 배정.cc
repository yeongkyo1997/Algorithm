#include <bits/stdc++.h>
using namespace std;

static const int INF = 1e9;

int N, M;
vector<int> adj[201];
int pairU[201];
int pairV[201];
int dist[201];

bool BFS()
{
    queue<int> q;

    for (int u = 1; u <= N; u++)
    {

        if (pairU[u] == 0)
        {
            dist[u] = 0;
            q.push(u);
        }
        else
        {
            dist[u] = INF;
        }
    }
    dist[0] = INF;

    while (!q.empty())
    {
        int u = q.front();
        q.pop();

        if (dist[u] < dist[0])
        {

            for (int v : adj[u])
            {

                if (pairV[v] == 0)
                {
                    dist[0] = dist[u] + 1;
                }

                else if (dist[pairV[v]] == INF)
                {
                    dist[pairV[v]] = dist[u] + 1;
                    q.push(pairV[v]);
                }
            }
        }
    }

    return dist[0] != INF;
}

bool DFS(int u)
{
    if (u != 0)
    {
        for (int v : adj[u])
        {

            if (pairV[v] == 0 ||
                (dist[pairV[v]] == dist[u] + 1 && DFS(pairV[v])))
            {

                pairV[v] = u;
                pairU[u] = v;
                return true;
            }
        }

        dist[u] = INF;
        return false;
    }
    return true;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N >> M;
    for (int i = 1; i <= N; i++)
    {
        int S;
        cin >> S;
        while (S--)
        {
            int barn;
            cin >> barn;
            adj[i].push_back(barn);
        }
    }

    int matching = 0;

    while (BFS())
    {
        for (int i = 1; i <= N; i++)
        {

            if (pairU[i] == 0 && DFS(i))
            {
                matching++;
            }
        }
    }

    cout << matching << "\n";
    return 0;
}