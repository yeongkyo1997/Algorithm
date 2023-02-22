#include <cstdio>
#include <algorithm>
using namespace std;

int n, d[10001], p[10001];

void solve() {
	d[1] = p[1], d[2] = p[1] + p[2];
	for (int i = 3; i <= n; i++) {
		d[i] = d[i - 1];
		d[i] = max(d[i], d[i - 2] + p[i]);
		d[i] = max(d[i], d[i - 3] + p[i - 1] + p[i]);
	}
	printf("%d\n", d[n]);
}

int main() {
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) scanf("%d", &p[i]);
	solve();
	return 0;
}