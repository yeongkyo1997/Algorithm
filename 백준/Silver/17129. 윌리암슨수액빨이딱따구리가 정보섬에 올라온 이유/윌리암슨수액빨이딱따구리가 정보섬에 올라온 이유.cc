#include <iostream>
#include <queue>
#include <vector>
#include <tuple>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<string> board(n);
    for (int i = 0; i < n; i++)
    {
        cin >> board[i];
    }

    int startX = -1, startY = -1;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (board[i][j] == '2')
            {
                startX = i;
                startY = j;
                break;
            }
        }
        if (startX != -1)
            break;
    }

    vector<vector<bool>> visited(n, vector<bool>(m, false));
    queue<tuple<int, int, int>> q;
    q.push({startX, startY, 0});
    visited[startX][startY] = true;

    int dx[4] = {1, -1, 0, 0};
    int dy[4] = {0, 0, 1, -1};

    while (!q.empty())
    {
        auto [x, y, dist] = q.front();
        q.pop();

        if (board[x][y] == '3' || board[x][y] == '4' || board[x][y] == '5')
        {
            cout << "TAK" << "\n"
                 << dist << "\n";
            return 0;
        }

        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m)
            {
                if (!visited[nx][ny] && board[nx][ny] != '1')
                {
                    visited[nx][ny] = true;
                    q.push({nx, ny, dist + 1});
                }
            }
        }
    }

    cout << "NIE" << "\n";
    return 0;
}