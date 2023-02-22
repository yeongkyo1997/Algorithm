#include <cstdio>
#include <algorithm>
using namespace std;

int n, d[100001][3], p[100001][2];

void solve() {
	d[1][0] = p[1][0], d[1][1] = p[1][1], d[1][2] = 0;
	for (int i = 2; i <= n; i++) {
		d[i][0] = max(d[i - 1][1], d[i - 1][2]) + p[i][0];
		d[i][1] = max(d[i - 1][0], d[i - 1][2]) + p[i][1];
		d[i][2] = max(max(d[i - 1][0], d[i - 1][1]), d[i - 1][2]);
	}
	printf("%d\n", max(max(d[n][0], d[n][1]), d[n][2]));
}

int main() {
	int t;
	scanf("%d", &t);
	while (t--) {
		scanf("%d", &n);
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j <= n; j++) {
				scanf("%d", &p[j][i]);
			}
		}
		solve();
	}
}