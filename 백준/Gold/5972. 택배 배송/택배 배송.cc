#include <bits/stdc++.h>
using namespace std;

const int INF = INT_MAX;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M;
    cin >> N >> M;

    vector<vector<pair<int, int>>> graph(N + 1);

    for (int i = 0; i < M; i++)
    {
        int A, B, C;
        cin >> A >> B >> C;
        graph[A].push_back({B, C});
        graph[B].push_back({A, C});
    }

    vector<int> dist(N + 1, INF);
    dist[1] = 0;

    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push({0, 1});

    while (!pq.empty())
    {
        auto curCost = pq.top().first;
        auto curNode = pq.top().second;
        pq.pop();

        if (dist[curNode] < curCost)
            continue;

        for (auto &next : graph[curNode])
        {
            int nextNode = next.first;
            int nextCost = next.second;
            int newDist = curCost + nextCost;

            if (newDist < dist[nextNode])
            {
                dist[nextNode] = newDist;
                pq.push({newDist, nextNode});
            }
        }
    }

    cout << dist[N] << "\n";

    return 0;
}