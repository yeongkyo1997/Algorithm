#include <stdio.h>

int n, ans, a[1001], d[1001];

int main() {
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d", &a[i]);
		d[i] = a[i];
		for (int j = 0; j <= i; j++) {
			if (a[j] < a[i] && d[i] < d[j] + a[i])
				d[i] = d[j] + a[i];
		}
		ans = ans > d[i] ? ans : d[i];
	}

	printf("%d", ans);

	return 0;
}