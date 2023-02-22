#include <cstdio>

int d[1001];

int solve(int n) {
	d[0] = d[1] = 1;
	for (int i = 2; i <= n; i++) {
		d[i] = d[i - 1] + d[i - 2];
		d[i] %= 10007;
	}
	return d[n];
}

int main() {
	int n;
	scanf("%d", &n);
	printf("%d\n", solve(n));
	return 0;
}