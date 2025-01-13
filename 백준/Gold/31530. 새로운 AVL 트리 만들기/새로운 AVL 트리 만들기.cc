#include <bits/stdc++.h>
using namespace std;

static const int MOD = 1000000007;
static const int MAXH = 1000000;

static int dp[8][MAXH + 1];

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    for (int i = 1; i < 8; i++)
    {
        dp[i][0] = 1;
        dp[i][1] = 1;
    }

    for (int i = 1; i < 8; i++)
    {
        for (int h = 2; h <= MAXH; h++)
        {
            long long ways = 0;

            if (i & 2)
            {
                ways += (long long)dp[i][h - 1] * dp[i][h - 1];
            }

            if (i & 1)
            {
                ways += (long long)dp[i][h - 1] * dp[i][h - 2];
            }

            if (i & 4)
            {
                ways += (long long)dp[i][h - 1] * dp[i][h - 2];
            }

            dp[i][h] = (int)(ways % MOD);
        }
    }

    int T;
    cin >> T;
    while (T--)
    {
        long long h;
        int k;
        cin >> h >> k;

        int mask = 0;
        for (int i = 0; i < k; i++)
        {
            int val;
            cin >> val;
            switch (val)
            {
            case -1:
                mask |= 1;
                break;
            case 0:
                mask |= 2;
                break;
            case 1:
                mask |= 4;
                break;
            }
        }

        cout << dp[mask][h] << "\n";
    }

    return 0;
}