#include <iostream>

using namespace std;

int n, m, b, a[257], result = 1e9, hei, i, j, ret, bb;

int main() {
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	for (cin >> n >> m >> b; i < n * m; i++) {
		cin >> j;
		a[j]++;
	}

	for (i = 256; ~i; i--) {
		ret = 0;
		bb = b;

		for (j = 256; j > i; j--) {
			ret += a[j] * (j - i) * 2;
			bb += a[j] * (j - i);
		}

		for (j = i - 1; ~j; j--) {
			ret += a[j] * (i - j);
			bb -= a[j] * (i - j);
		}

		if (bb < 0)
			continue;

		if (result > ret) {
			result = ret;
			hei = i;
		}
	}
	cout << result << ' ' << hei;
}
