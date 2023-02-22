#include <stdio.h>
#include <string.h>

#define MAX(a,b) a>b ? a:b
#define _CRT_SECURE_NO_WARNINGS
char a[1001], b[1001];
int n, m;
int dp[1001][1001];
int solve(int pos1, int pos2) {
	if (pos1 == n || pos2 == m) return 0;
	if (a[pos1] == b[pos2])
		return 1 + solve(pos1 + 1, pos2 + 1);

	int ret = 0;
	if (dp[pos1][pos2] != -1) return dp[pos1][pos2];
	ret = MAX(solve(pos1 + 1, pos2), solve(pos1, pos2 + 1));
	return dp[pos1][pos2] = ret;
}
int main() {

	scanf("%s %s", a, b);
	n = strlen(a); m = strlen(b);
	memset(dp, -1, sizeof(int) * 1001 * 1001);
	int ret = solve(0, 0);
	printf("%d\n", ret);
}