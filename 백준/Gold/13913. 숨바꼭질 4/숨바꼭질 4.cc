#include <bits/stdc++.h>
using namespace std;

static const int MAX = 100000;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, K;
    cin >> N >> K;

    vector<int> dist(MAX + 1, -1);
    vector<int> parent(MAX + 1, -1);

    queue<int> q;
    dist[N] = 0;
    q.push(N);

    while (!q.empty())
    {
        int x = q.front();
        q.pop();

        if (x == K)
        {
            break;
        }

        if (x - 1 >= 0 && dist[x - 1] == -1)
        {
            dist[x - 1] = dist[x] + 1;
            parent[x - 1] = x;
            q.push(x - 1);
        }

        if (x + 1 <= MAX && dist[x + 1] == -1)
        {
            dist[x + 1] = dist[x] + 1;
            parent[x + 1] = x;
            q.push(x + 1);
        }

        if (2 * x <= MAX && dist[2 * x] == -1)
        {
            dist[2 * x] = dist[x] + 1;
            parent[2 * x] = x;
            q.push(2 * x);
        }
    }

    cout << dist[K] << "\n";

    vector<int> path;
    for (int cur = K; cur != -1; cur = parent[cur])
    {
        path.push_back(cur);
    }

    reverse(path.begin(), path.end());

    for (auto &p : path)
    {
        cout << p << " ";
    }
    cout << "\n";

    return 0;
}