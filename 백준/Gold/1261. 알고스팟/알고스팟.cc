#include <iostream>
#include <vector>
#include <deque>
#include <string>
#include <algorithm>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int M, N;
    cin >> M >> N;

    vector<string> maze(N);
    for (int i = 0; i < N; i++)
    {
        cin >> maze[i];
    }

    vector<vector<int>> dist(N, vector<int>(M, 1e9));
    dist[0][0] = 0;

    deque<pair<int, int>> dq;
    dq.push_back({0, 0});

    int dy[4] = {1, -1, 0, 0};
    int dx[4] = {0, 0, 1, -1};

    while (!dq.empty())
    {
        auto [cy, cx] = dq.front();
        dq.pop_front();

        int currentCost = dist[cy][cx];

        for (int i = 0; i < 4; i++)
        {
            int ny = cy + dy[i];
            int nx = cx + dx[i];

            if (ny < 0 || ny >= N || nx < 0 || nx >= M)
                continue;

            int nextCost = currentCost + (maze[ny][nx] == '1' ? 1 : 0);

            if (dist[ny][nx] > nextCost)
            {
                dist[ny][nx] = nextCost;

                if (maze[ny][nx] == '0')
                {
                    dq.push_front({ny, nx});
                }
                else
                {
                    dq.push_back({ny, nx});
                }
            }
        }
    }

    cout << dist[N - 1][M - 1] << "\n";
    return 0;
}