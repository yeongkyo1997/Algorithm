#include<stdio.h>
#include<algorithm>
using namespace std;

int dp[1001] = { 0 };
int p[1001];
int main() {

	int n;
	scanf("%d", &n);

	for (int i = 1; i <= n; i++) {
		scanf("%d", &p[i]);
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= i; j++) {
			dp[i] = max(dp[i], (dp[i - j] + p[j]));
		}
	}
	printf("%d", dp[n]);
	return 0;
}