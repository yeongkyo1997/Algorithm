#include <stdio.h>
#include <limits.h>

#define MIN(a, b) (((a) < (b)) ? (a) : (b))

int main()
{
    int n;
    scanf("%d", &n);

    int dp[5001];
    for (int i = 0; i <= n; i++)
    {
        dp[i] = -1;
    }
    dp[0] = 0;

    for (int i = 0; i <= n; i++)
    {
        if (dp[i] == -1)
            continue;
        if (i + 3 <= n)
            dp[i + 3] = dp[i + 3] != -1 ? MIN(dp[i + 3], dp[i] + 1) : dp[i] + 1;
        if (i + 5 <= n)
            dp[i + 5] = dp[i + 5] != -1 ? MIN(dp[i + 5], dp[i] + 1) : dp[i] + 1;
    }

    printf("%d\n", dp[n]);
    return 0;
}