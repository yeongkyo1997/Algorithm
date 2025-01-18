#include <bits/stdc++.h>
using namespace std;

const int MAXW = 1000;

int N, W;
pair<int, int> eventPos[MAXW + 1];
int dp[MAXW + 1][MAXW + 1];
int choice[MAXW + 1][MAXW + 1];

int visited[MAXW + 1][MAXW + 1];

int distCar1(int a, int i)
{
    if (a == 0)
    {

        return abs(eventPos[i].first - 1) + abs(eventPos[i].second - 1);
    }
    else
    {

        return abs(eventPos[i].first - eventPos[a].first) + abs(eventPos[i].second - eventPos[a].second);
    }
}

int distCar2(int b, int i)
{
    if (b == 0)
    {

        return abs(eventPos[i].first - N) + abs(eventPos[i].second - N);
    }
    else
    {

        return abs(eventPos[i].first - eventPos[b].first) + abs(eventPos[i].second - eventPos[b].second);
    }
}

int solveDP(int a, int b)
{

    int nextEvent = max(a, b) + 1;

    if (nextEvent > W)
        return 0;

    if (visited[a][b] != -1)
        return dp[a][b];

    int cost1 = distCar1(a, nextEvent) + solveDP(nextEvent, b);

    int cost2 = distCar2(b, nextEvent) + solveDP(a, nextEvent);

    if (cost1 < cost2)
    {
        dp[a][b] = cost1;
        choice[a][b] = 1;
    }
    else
    {
        dp[a][b] = cost2;
        choice[a][b] = 2;
    }

    visited[a][b] = 1;
    return dp[a][b];
}

void reconstruct(int a, int b)
{
    int nextEvent = max(a, b) + 1;
    if (nextEvent > W)
        return;

    int c = choice[a][b];
    cout << c << "\n";
    if (c == 1)
        reconstruct(nextEvent, b);
    else
        reconstruct(a, nextEvent);
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;
    cin >> W;
    for (int i = 1; i <= W; i++)
    {
        cin >> eventPos[i].first >> eventPos[i].second;
    }

    memset(visited, -1, sizeof(visited));

    int ans = solveDP(0, 0);

    cout << ans << "\n";
    reconstruct(0, 0);

    return 0;
}