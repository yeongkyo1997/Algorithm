#include<stdio.h>
int dp[1001];
int num[1001];
int v[1001];
int max = -2147000000;
void go(int p) {
	if (p == 0) return;
	go(v[p]);
	printf("%d ", num[p]);

}
// go(6) go(5), go(4), go(2)
// 10 20 30 50
int main() {

	int n;
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		scanf("%d", &num[i]);
	}
	for (int i = 1; i <= n; i++) {

		dp[i] = 1;
		for (int j = 1; j < i; j++) {
			if (num[i] > num[j] && dp[i] < dp[j] + 1) {
				dp[i] = dp[j] + 1;
				v[i] = j;
			}
		}

	}
	int p = 0;
	for (int i = 1; i <= n; i++) {
		if (max < dp[i]) {
			max = dp[i];
			p = i;
		}
	}
	printf("%d\n", max);
	go(p);
	printf("\n");
	return 0;
}