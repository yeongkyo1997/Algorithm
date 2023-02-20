#include <stdio.h>
int arr[1004][1004], dp[1004][1004], i, j, n, m;
int max(int a, int b) {
	return (a > b) ? a : b;
}
int main() {
	scanf("%d %d", &n, &m);
	for (i = 1; i <= n; i++)
		for (j = 1; j <= m; j++)
			scanf("%d", &arr[i][j]);
	for (i = 1; i <= n; i++) {
		for (j = 1; j <= m; j++) {
			dp[i][j] = arr[i][j] + max(max(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
		}
	}
	printf("%d", dp[n][m]);
	return 0;
}