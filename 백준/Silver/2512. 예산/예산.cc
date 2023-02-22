#include <cstdio>
#include <algorithm>
typedef long long ll;
using namespace std;
ll n, a[10000], m, lo, hi, ma, s;
int main() {
	scanf("%lld", &n);
	for (int i = 0; i < n; i++) {
		scanf("%lld", &a[i]);
		ma = max(a[i], ma);
		s += a[i];
	}
	scanf("%lld", &m);
	if (m >= s) {
		printf("%lld\n", ma);
		return 0;
	}
	lo = 0;
	hi = 21000000000;
	while (lo < hi) {
		ll mid = (lo + hi) >> 1;
		ll r = 0;
		for (int i = 0; i < n; i++) {
			if (mid >= a[i])
				r += a[i];
			else
				r += mid;
		}
		if (r <= m)
			lo = mid + 1;
		else
			hi = mid;
	}
	printf("%lld\n", lo - 1);
}