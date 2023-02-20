#include <bits/stdc++.h>
#define endl '\n'
using namespace std;

int main() {

	int N, R1, R, a, b, c;
	cin >> N >> R1;
	for (int i = 1; i < N; i++) {
		cin >> R;
		a = R1;
		b = R;
		while (b) {
			c = a % b;
			a = b;
			b = c;
		}
		printf("%d/%d\n", R1 / a, R / a);
	}

	return 0;
}