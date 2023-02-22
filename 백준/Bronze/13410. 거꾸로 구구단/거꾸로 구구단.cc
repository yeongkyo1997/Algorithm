#include <iostream>
#include <algorithm>
using namespace std;

int MAX = 0;
int n;
int k;

int reverse(int num) {
	int re = 0;
	while (1) {
		re += num % 10;
		num /= 10;
		if (num == 0)
			break;
		re *= 10;
	}
	return re;
}

int main() {
	cin >> n >> k;

	for (int i = 1; i <= k; i++) {
		MAX = max(MAX, reverse(i * n));
	}

	cout << MAX;
}