#include <iostream>
using namespace std;

int n, a[88];

void gogo(int cnt) {
	for (int i = 1; i <= cnt / 2; i++) {
		if (equal(a + cnt - i, a + cnt, a + cnt - i - i)) return;
	}
	if (cnt == n) {
		for (int i = 0; i < n; i++) printf("%d", a[i]);
		exit(0);
	}
	for (int i = 1; i <= 3; i++) {
		a[cnt] = i;
		gogo(cnt + 1);
	}
}

int main() {
	scanf("%d", &n);
	gogo(0);
	return 0;
}