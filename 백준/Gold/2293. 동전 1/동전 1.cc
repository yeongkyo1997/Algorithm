#include <stdio.h>

int main() {
    int n, k;
    int coin_values[100];
    int dp[10001] = {0};

    scanf("%d %d", &n, &k);

    for (int i = 0; i < n; i++) {
        scanf("%d", &coin_values[i]);
    }

    dp[0] = 1;

    for (int i = 0; i < n; i++) {
        for (int j = coin_values[i]; j <= k; j++) {
            dp[j] += dp[j - coin_values[i]];
        }
    }

    printf("%d\n", dp[k]);

    return 0;
}