#include <stdio.h>

int main() {
	int n, x;
	int i;
	int num;
	scanf("%d %d", &n, &x);
	for (i = 0; i < n; i++) {
		scanf("%d", &num);
		if (num < x) {
			printf("%d ", num);
		}
	}
}