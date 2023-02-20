#include<iostream>
 
#define endl "\n"
#define MAX 15 + 1
using namespace std;
 
int N, M, K;
int DP[MAX][MAX];
 
pair<int, int> Pos;
 
void Input()
{
    Pos.first = Pos.second = -1;
 
    cin >> N >> M >> K;
    int Num = 1;
    if (K != 0)
    {
        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= M; j++)
            {
                if (Num == K)
                {
                    Pos.first = i;
                    Pos.second = j;
                }
                Num++;
            }
        }
    }
}
 
void Solution()
{
    DP[1][1] = 1;
    if (K == 0)
    {
        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= M; j++)
            {
                DP[i][j] = DP[i][j] + DP[i - 1][j] + DP[i][j - 1];
            }
        }
        cout << DP[N][M] << endl;
    }
    else
    {
        for (int i = 1; i <= Pos.first; i++)
        {
            for (int j = 1; j <= Pos.second; j++)
            {
                DP[i][j] = DP[i][j] + DP[i - 1][j] + DP[i][j - 1];
            }
        }
 
        int Temp = DP[Pos.first][Pos.second];
        DP[Pos.first][Pos.second] = 1;
 
        for (int i = Pos.first; i <= N; i++)
        {
            for (int j = Pos.second; j <= M; j++)
            {
                if (i == Pos.first && j == Pos.second) continue;
                DP[i][j] = DP[i][j] + DP[i - 1][j] + DP[i][j - 1];
            }
        }
        cout << Temp * DP[N][M] << endl;
    }
}
 
void Solve()
{
    Input();
    Solution();
}
 
int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
 
    //freopen("Input.txt", "r", stdin);
    Solve();
 
    return 0;
}