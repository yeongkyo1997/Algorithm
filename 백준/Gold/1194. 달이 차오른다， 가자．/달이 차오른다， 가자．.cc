#include <iostream>
#include <vector>
#include <queue>
#include <string>

using namespace std;

int N, M;
vector<string> board;
vector<vector<vector<int> > > visited;
vector<pair<int, int> > d;

int bfs(int x, int y, int keys)
{
    queue<int> qx, qy, qk;
    qx.push(x); qy.push(y); qk.push(keys);
    visited[x][y][keys] = 1;

    while (!qx.empty())
    {
        x = qx.front(); qx.pop();
        y = qy.front(); qy.pop();
        keys = qk.front(); qk.pop();
        if (board[x][y] == '1')
            return visited[x][y][keys] - 1;
        for (int i = 0; i < 4; i++)
        {
            int nx = x + d[i].first, ny = y + d[i].second;
            if (nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny] == '#' || visited[nx][ny][keys] != 0)
                continue;
            if ('A' <= board[nx][ny] && board[nx][ny] <= 'F' && (keys & (1 << (board[nx][ny] - 'A'))) == 0)
                continue;
            if ('A' <= board[nx][ny] && board[nx][ny] <= 'F' && (keys & (1 << (board[nx][ny] - 'A'))) != 0)
            {
                visited[nx][ny][keys] = visited[x][y][keys] + 1;
                qx.push(nx); qy.push(ny); qk.push(keys);
            }
            if ('a' <= board[nx][ny] && board[nx][ny] <= 'f')
            {
                int k = keys | 1 << (board[nx][ny] - 'a');
                visited[nx][ny][k] = visited[x][y][keys] + 1;
                qx.push(nx); qy.push(ny); qk.push(k);
            }
            if (board[nx][ny] != '#')
            {
                visited[nx][ny][keys] = visited[x][y][keys] + 1;
                qx.push(nx); qy.push(ny); qk.push(keys);
            }
        }
    }
    return -1;
}

int main()
{
    cin >> N >> M;
    board.resize(N);
    visited.resize(N, vector<vector<int> >(M, vector<int>(1 << (6 + 1))));
    d.push_back(make_pair(-1, 0));
    d.push_back(make_pair(1, 0));
    d.push_back(make_pair(0, -1));
    d.push_back(make_pair(0, 1));
    for (int i = 0; i < N; i++)
        cin >> board[i];
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (board[i][j] == '0')
            {
                cout << bfs(i, j, 0) << endl;
                break;
            }
        }
    }
    return 0;
}