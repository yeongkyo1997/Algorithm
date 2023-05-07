#include <stdio.h>

int max(int a, int b) {
    return a > b ? a : b;
}

int main() {
    int n, i;
    scanf("%d", &n);

    int wine[n + 1], dp[n + 1];
    wine[0] = dp[0] = 0;

    for (i = 1; i <= n; i++) {
        scanf("%d", &wine[i]);
    }

    dp[1] = wine[1];
    if (n > 1) {
        dp[2] = wine[1] + wine[2];
    }

    for (i = 3; i <= n; i++) {
        dp[i] = max(dp[i - 1], max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
    }

    printf("%d\n", dp[n]);

    return 0;
}