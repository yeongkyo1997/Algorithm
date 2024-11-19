#include <bits/stdc++.h>
using namespace std;

int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

struct State
{
    int rx, ry;
    int bx, by;
    int moves;
};

int main()
{
    int N, M;
    cin >> N >> M;
    vector<string> board(N);
    for (auto &s : board)
        cin >> s;

    int rx, ry, bx, by, hole_x, hole_y;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (board[i][j] == 'R')
            {
                rx = i;
                ry = j;
                board[i][j] = '.';
            }
            if (board[i][j] == 'B')
            {
                bx = i;
                by = j;
                board[i][j] = '.';
            }
            if (board[i][j] == 'O')
            {
                hole_x = i;
                hole_y = j;
            }
        }
    }

    bool visited[10][10][10][10];
    memset(visited, false, sizeof(visited));
    queue<State> q;
    q.push(State{rx, ry, bx, by, 0});
    visited[rx][ry][bx][by] = true;
    int result = -1;

    while (!q.empty())
    {
        State current = q.front();
        q.pop();
        if (current.moves >= 10)
            continue;
        for (int dir = 0; dir < 4; dir++)
        {
            int nrx = current.rx, nry = current.ry;
            int nbx = current.bx, nby = current.by;
            bool red_in = false, blue_in = false;

            auto move_ball = [&](int &x, int &y) -> bool
            {
                while (true)
                {
                    if (board[x + dx[dir]][y + dy[dir]] == '#')
                        break;
                    x += dx[dir];
                    y += dy[dir];
                    if (x == hole_x && y == hole_y)
                        return true;
                }
                return false;
            };

            bool first_red = false;
            if (dir == 0)
            {
                if (current.rx < current.bx)
                    first_red = true;
            }
            else if (dir == 1)
            {
                if (current.rx > current.bx)
                    first_red = true;
            }
            else if (dir == 2)
            {
                if (current.ry < current.by)
                    first_red = true;
            }
            else if (dir == 3)
            {
                if (current.ry > current.by)
                    first_red = true;
            }

            if (first_red)
            {
                red_in = move_ball(nrx, nry);
                blue_in = move_ball(nbx, nby);
            }
            else
            {
                blue_in = move_ball(nbx, nby);
                red_in = move_ball(nrx, nry);
            }

            if (blue_in)
                continue;
            if (red_in)
            {
                result = current.moves + 1;
                cout << result;
                return 0;
            }

            if (nrx == nbx && nry == nby)
            {
                int red_dist = abs(nrx - current.rx) + abs(nry - current.ry);
                int blue_dist = abs(nbx - current.bx) + abs(nby - current.by);
                if (red_dist > blue_dist)
                {
                    nrx -= dx[dir];
                    nry -= dy[dir];
                }
                else
                {
                    nbx -= dx[dir];
                    nby -= dy[dir];
                }
            }

            if (!visited[nrx][nry][nbx][nby])
            {
                visited[nrx][nry][nbx][nby] = true;
                q.push(State{nrx, nry, nbx, nby, current.moves + 1});
            }
        }
    }

    cout << result;
}