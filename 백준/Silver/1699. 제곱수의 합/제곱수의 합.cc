#include <stdio.h>
#include <limits.h>

int dp[100001]; 

int main() {
    int n;
    scanf("%d", &n);
    
    for (int i = 1; i <= n; i++) {
        dp[i] = INT_MAX; 
    }

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j * j <= i; j++) { 
            dp[i] = (dp[i] < dp[i-j*j]+1) ? dp[i] : dp[i-j*j]+1;
        }
    }

    printf("%d\n", dp[n]); 

    return 0;
}