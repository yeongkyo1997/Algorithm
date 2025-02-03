#include <iostream>
#include <vector>
#include <queue>
#include <cstdlib>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    while (t--)
    {
        int n;
        cin >> n;
        vector<pair<int, int>> locations(n + 2);
        for (int i = 0; i < n + 2; i++)
        {
            cin >> locations[i].first >> locations[i].second;
        }

        vector<bool> visited(n + 2, false);
        queue<int> q;
        q.push(0);
        visited[0] = true;

        bool reachable = false;
        while (!q.empty())
        {
            int cur = q.front();
            q.pop();

            if (cur == n + 1)
            {
                reachable = true;
                break;
            }

            for (int i = 0; i < n + 2; i++)
            {
                if (!visited[i])
                {
                    int dist = abs(locations[cur].first - locations[i].first) + abs(locations[cur].second - locations[i].second);
                    if (dist <= 1000)
                    {
                        visited[i] = true;
                        q.push(i);
                    }
                }
            }
        }

        cout << (reachable ? "happy" : "sad") << "\n";
    }

    return 0;
}