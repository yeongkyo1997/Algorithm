#include <iostream>
#include <vector>
#include <string>
#include <queue>
#include <array>
#include <algorithm>

using namespace std;

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

long long calculateAnswer(int caseType, long long snowballDistance, long long sharedBlocks,
                          long long aOnlyBlocks, long long bOnlyBlocks, long long disToThreeWay)
{
    long long ret = 0;
    long long sum = sharedBlocks + aOnlyBlocks + bOnlyBlocks;

    for (long long i = snowballDistance - 1; i <= sum; i++)
    {
        if (caseType == 3 && i > sharedBlocks + aOnlyBlocks + disToThreeWay + 1)
        {
            sharedBlocks++;
        }
        if (caseType == 2)
        {
            ret += i / 2 + 1;
        }
        else
        {
            ret += min(i / 2 + 1, aOnlyBlocks + sharedBlocks + 1LL);
        }
        if (caseType == 1 && i > bOnlyBlocks + sharedBlocks)
        {
            ret -= i - bOnlyBlocks - sharedBlocks;
        }
    }

    return ret;
}

long long solution(vector<string> grid)
{
    int n = grid.size();
    int m = grid[0].size();

    int snowman[2][2];
    int snowmanIdx = 0;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (grid[i][j] == 'o')
            {
                snowman[snowmanIdx][0] = j;
                snowman[snowmanIdx][1] = i;
                snowmanIdx++;
            }
        }
    }

    vector<vector<vector<bool>>> been(2, vector<vector<bool>>(n, vector<bool>(m, false)));

    long long sharedBlocks = 0;
    long long aOnlyBlocks = 0;
    long long bOnlyBlocks = 0;

    int threeWays[2][3];
    threeWays[0][2] = -1;
    threeWays[1][2] = -1;

    long long snowballDistance = n * m + 1;
    bool isCase2 = false;

    for (int s = 0; s < 2; s++)
    {
        queue<array<int, 3>> q;
        q.push({snowman[s][0], snowman[s][1], 0});
        been[s][snowman[s][1]][snowman[s][0]] = true;

        while (!q.empty())
        {
            array<int, 3> cur = q.front();
            q.pop();
            int x = cur[0], y = cur[1], dis = cur[2];
            int choices = 0;

            for (int i = 0; i < 4; i++)
            {
                int nx = x + dx[i], ny = y + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[ny][nx] == '#')
                    continue;

                choices++;
                if (been[s][ny][nx])
                    continue;

                if (grid[ny][nx] == 'o')
                {
                    snowballDistance = min(snowballDistance, (long long)dis + 1);
                    continue;
                }

                been[s][ny][nx] = true;
                q.push({nx, ny, dis + 1});
            }

            if (choices >= 3)
            {

                if (s == 1 && been[0][y][x] && grid[y][x] == '.')
                    isCase2 = true;

                if (threeWays[s][2] == -1)
                {
                    threeWays[s][0] = x;
                    threeWays[s][1] = y;
                    threeWays[s][2] = dis;
                }
            }
        }
    }

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (grid[i][j] == 'o')
                continue;
            else if (been[0][i][j] && been[1][i][j])
                sharedBlocks++;
            else if (been[0][i][j])
                aOnlyBlocks++;
            else if (been[1][i][j])
                bOnlyBlocks++;
        }
    }

    if (threeWays[0][2] == -1 && threeWays[1][2] == -1)
    {
        return calculateAnswer(1, snowballDistance, sharedBlocks, min(aOnlyBlocks, bOnlyBlocks),
                               max(aOnlyBlocks, bOnlyBlocks), 250001);
    }

    if ((threeWays[0][2] != -1 && threeWays[1][2] != -1) || isCase2)
    {
        return calculateAnswer(2, snowballDistance, sharedBlocks, aOnlyBlocks, bOnlyBlocks, 0);
    }

    if (threeWays[0][2] == -1)
    {
        return calculateAnswer(3, snowballDistance, sharedBlocks, aOnlyBlocks, bOnlyBlocks, threeWays[1][2]);
    }
    else
    {
        return calculateAnswer(3, snowballDistance, sharedBlocks, bOnlyBlocks, aOnlyBlocks, threeWays[0][2]);
    }
}
