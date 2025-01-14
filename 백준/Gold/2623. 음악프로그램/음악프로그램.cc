#include <bits/stdc++.h>
using namespace std;

static const int MAX = 1000;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M;
    cin >> N >> M;

    vector<int> graph[MAX + 1];
    int in_degree[MAX + 1] = {0};

    for (int i = 0; i < M; i++)
    {
        int k;
        cin >> k;
        vector<int> arr(k);
        for (int j = 0; j < k; j++)
        {
            cin >> arr[j];
        }
        for (int j = 0; j < k - 1; j++)
        {
            int from = arr[j];
            int to = arr[j + 1];
            graph[from].push_back(to);
            in_degree[to]++;
        }
    }

    queue<int> q;
    for (int i = 1; i <= N; i++)
    {
        if (in_degree[i] == 0)
        {
            q.push(i);
        }
    }

    vector<int> result;

    while (!q.empty())
    {
        int cur = q.front();
        q.pop();
        result.push_back(cur);

        for (int nxt : graph[cur])
        {
            if (--in_degree[nxt] == 0)
            {
                q.push(nxt);
            }
        }
    }

    if ((int)result.size() < N)
    {
        cout << 0 << "\n";
    }
    else
    {
        for (int singer : result)
        {
            cout << singer << "\n";
        }
    }

    return 0;
}