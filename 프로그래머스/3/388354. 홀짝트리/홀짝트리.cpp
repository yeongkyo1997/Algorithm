#include <string>
#include <vector>
#include <queue>
#include <unordered_map>
using namespace std;

vector<int> solution(vector<int> nodes, vector<vector<int>> edges)
{

    unordered_map<int, vector<int>> adj;

    unordered_map<int, int> deg;

    for (int node : nodes)
    {
        adj[node] = vector<int>();
        deg[node] = 0;
    }
    for (auto &edge : edges)
    {
        int u = edge[0], v = edge[1];
        adj[u].push_back(v);
        adj[v].push_back(u);
        deg[u]++;
        deg[v]++;
    }

    unordered_map<int, bool> visited;
    for (int node : nodes)
    {
        visited[node] = false;
    }

    int countHoljak = 0;
    int countYeokHoljak = 0;

    for (int node : nodes)
    {
        if (!visited[node])
        {
            int countA = 0, countB = 0;
            int compSize = 0;
            queue<int> q;
            q.push(node);
            visited[node] = true;
            while (!q.empty())
            {
                int cur = q.front();
                q.pop();
                compSize++;
                int p = (cur % 2 + 2) % 2;
                int d = deg[cur] % 2;
                if (p == d)
                    countA++;
                else
                    countB++;

                for (int nxt : adj[cur])
                {
                    if (!visited[nxt])
                    {
                        visited[nxt] = true;
                        q.push(nxt);
                    }
                }
            }
            if (countA == 1)
                countHoljak++;
            if (countB == 1)
                countYeokHoljak++;
        }
    }

    return {countHoljak, countYeokHoljak};
}
