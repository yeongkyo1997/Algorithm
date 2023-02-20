#include<stdio.h>
#include<algorithm>
using namespace std;
int dp[100001];
int num[100001];
int main() {
	int n;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &num[i]);
	}
	dp[0] = num[0];
	for (int i = 0; i < n; i++) {
		dp[i] = max(num[i], dp[i - 1] + num[i]);
	}
	int ans = -2147000000;
	for (int i = 0; i < n; i++) {

		if (dp[i] > ans) ans = dp[i];
	}
	printf("%d", ans);
}