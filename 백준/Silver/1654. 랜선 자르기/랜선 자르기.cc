#include <cstdio>
#include <algorithm>

typedef long long ll;

using namespace std;

ll k, n;
ll lo, hi;
ll a[10010];

int main() {
	scanf("%lld%lld", &k, &n);

	for (int i = 0; i < k; i++)
		scanf("%lld", &a[i]);

	lo = 0;
	hi = 10000000000001;

	while (lo < hi) {
		ll mid = (lo + hi) >> 1;
		ll t = 0;

		for (int i = 0; i < k; i++)
			t += a[i] / mid;

		if (t >= n)
			lo = mid + 1;
		else
			hi = mid;
	}

	printf("%lld\n", lo - 1);
}