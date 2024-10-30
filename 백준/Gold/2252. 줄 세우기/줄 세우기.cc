#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <unordered_map>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N, M;
    cin >> N >> M;
    unordered_map<int, int> degree;
    unordered_map<int, vector<int>> graph;
    for (int i = 1; i <= N; i++)
    {
        degree[i] = 0;
    }
    for (int i = 0; i < M; ++i)
    {
        int a, b;
        cin >> a >> b;
        degree.insert({b, degree[b]++});
        graph[a].push_back(b);
    }
    queue<int> q;

    for (int i = 1; i <= N; i++)
    {
        if (degree[i] == 0)
        {
            q.push(i);
        }
    }

    vector<int> result;
    while (!q.empty())
    {
        int x = q.front();
        q.pop();
        result.push_back(x);
        for (auto g : graph[x])
        {
            if (--degree[g] == 0)
            {
                q.push(g);
            }
        }
    }

    for (auto r : result)
    {
        cout << r << " ";
    }
}