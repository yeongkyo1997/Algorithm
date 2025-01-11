#include <bits/stdc++.h>
using namespace std;

static const int N = 4;

int dx[8] = {0, -1, -1, -1, 0, 1, 1, 1};
int dy[8] = {-1, -1, 0, 1, 1, 1, 0, -1};

int sx[4] = {-1, 0, 1, 0};
int sy[4] = {0, -1, 0, 1};

long long fishCount[N][N][8];

long long copyCount[N][N][8];

int smell[N][N];

int shark_r, shark_c;

bool inRange(int r, int c)
{
    return (0 <= r && r < N && 0 <= c && c < N);
}

int rotateLeft(int d)
{

    return (d + 7) % 8;
}

long long countFish()
{
    long long total = 0LL;
    for (int r = 0; r < N; r++)
    {
        for (int c = 0; c < N; c++)
        {
            for (int d = 0; d < 8; d++)
            {
                total += fishCount[r][c][d];
            }
        }
    }
    return total;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int M, S;
    cin >> M >> S;

    for (int i = 0; i < M; i++)
    {
        int fx, fy, d;
        cin >> fx >> fy >> d;

        fx--;
        fy--;
        d--;
        fishCount[fx][fy][d]++;
    }

    cin >> shark_r >> shark_c;
    shark_r--;
    shark_c--;

    for (int turn = 1; turn <= S; turn++)
    {

        for (int r = 0; r < N; r++)
        {
            for (int c = 0; c < N; c++)
            {
                for (int d = 0; d < 8; d++)
                {
                    copyCount[r][c][d] = fishCount[r][c][d];
                }
            }
        }

        {
            static long long newFishCount[N][N][8];
            memset(newFishCount, 0, sizeof(newFishCount));

            for (int r = 0; r < N; r++)
            {
                for (int c = 0; c < N; c++)
                {
                    for (int d = 0; d < 8; d++)
                    {
                        long long cnt = fishCount[r][c][d];
                        if (cnt == 0)
                            continue;

                        int nd = d;
                        bool canMove = false;
                        for (int k = 0; k < 8; k++)
                        {
                            int nr = r + dx[nd];
                            int nc = c + dy[nd];

                            if (inRange(nr, nc) && !(nr == shark_r && nc == shark_c) && smell[nr][nc] == 0)
                            {

                                canMove = true;
                                break;
                            }

                            nd = rotateLeft(nd);
                        }

                        if (!canMove)
                        {

                            newFishCount[r][c][d] += cnt;
                        }
                        else
                        {

                            int nr = r + dx[nd];
                            int nc = c + dy[nd];
                            newFishCount[nr][nc][nd] += cnt;
                        }
                    }
                }
            }

            for (int r = 0; r < N; r++)
            {
                for (int c = 0; c < N; c++)
                {
                    for (int d = 0; d < 8; d++)
                    {
                        fishCount[r][c][d] = newFishCount[r][c][d];
                    }
                }
            }
        }

        {

            int sr = shark_r;
            int sc = shark_c;

            long long maxFishEaten = -1;
            vector<int> bestPath(3, 0);

            for (int d1 = 0; d1 < 4; d1++)
            {
                int r1 = sr + sx[d1];
                int c1 = sc + sy[d1];
                if (!inRange(r1, c1))
                    continue;

                for (int d2 = 0; d2 < 4; d2++)
                {
                    int r2 = r1 + sx[d2];
                    int c2 = c1 + sy[d2];
                    if (!inRange(r2, c2))
                        continue;

                    for (int d3 = 0; d3 < 4; d3++)
                    {
                        int r3 = r2 + sx[d3];
                        int c3 = c2 + sy[d3];
                        if (!inRange(r3, c3))
                            continue;

                        long long sumFish = 0;

                        bool visited[4][4];
                        memset(visited, false, sizeof(visited));

                        if (!visited[r1][c1])
                        {
                            sumFish += accumulate(fishCount[r1][c1],
                                                  fishCount[r1][c1] + 8, 0LL);
                            visited[r1][c1] = true;
                        }

                        if (!visited[r2][c2])
                        {
                            sumFish += accumulate(fishCount[r2][c2],
                                                  fishCount[r2][c2] + 8, 0LL);
                            visited[r2][c2] = true;
                        }

                        if (!visited[r3][c3])
                        {
                            sumFish += accumulate(fishCount[r3][c3],
                                                  fishCount[r3][c3] + 8, 0LL);
                            visited[r3][c3] = true;
                        }

                        if (sumFish > maxFishEaten)
                        {
                            maxFishEaten = sumFish;
                            bestPath = {d1, d2, d3};
                        }
                        else if (sumFish == maxFishEaten)
                        {

                            vector<int> curPath = {d1, d2, d3};
                            if (curPath < bestPath)
                            {
                                bestPath = curPath;
                            }
                        }
                    }
                }
            }

            int rr = sr, cc = sc;
            for (int i = 0; i < 3; i++)
            {
                int d = bestPath[i];
                rr += sx[d];
                cc += sy[d];

                long long fishHere = 0;
                for (int dd = 0; dd < 8; dd++)
                {
                    fishHere += fishCount[rr][cc][dd];
                }
                if (fishHere > 0)
                {

                    for (int dd = 0; dd < 8; dd++)
                    {
                        fishCount[rr][cc][dd] = 0;
                    }

                    smell[rr][cc] = turn;
                }
            }

            shark_r = rr;
            shark_c = cc;
        }

        if (turn - 2 >= 1)
        {
            for (int r = 0; r < N; r++)
            {
                for (int c = 0; c < N; c++)
                {
                    if (smell[r][c] == (turn - 2))
                    {
                        smell[r][c] = 0;
                    }
                }
            }
        }

        for (int r = 0; r < N; r++)
        {
            for (int c = 0; c < N; c++)
            {
                for (int d = 0; d < 8; d++)
                {
                    if (copyCount[r][c][d] > 0)
                    {
                        fishCount[r][c][d] += copyCount[r][c][d];
                    }
                }
            }
        }
    }

    cout << countFish() << "\n";

    return 0;
}