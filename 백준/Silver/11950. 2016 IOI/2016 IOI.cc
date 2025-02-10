#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M;
    cin >> N >> M;

    vector<string> board(N);
    for (int i = 0; i < N; i++)
    {
        cin >> board[i];
    }

    int ans = 1e9;

    for (int i = 0; i < N - 2; i++)
    {
        for (int j = i + 1; j < N - 1; j++)
        {
            int changes = 0;

            for (int r = 0; r <= i; r++)
            {
                for (int c = 0; c < M; c++)
                {
                    if (board[r][c] != 'W')
                        changes++;
                }
            }

            for (int r = i + 1; r <= j; r++)
            {
                for (int c = 0; c < M; c++)
                {
                    if (board[r][c] != 'B')
                        changes++;
                }
            }

            for (int r = j + 1; r < N; r++)
            {
                for (int c = 0; c < M; c++)
                {
                    if (board[r][c] != 'R')
                        changes++;
                }
            }
            ans = min(ans, changes);
        }
    }

    cout << ans << "\n";
    return 0;
}