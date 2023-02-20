#include <iostream>

using namespace std;

int allSum(int n) {
	int sum = 0;

	while (n != 0) {
		sum += n % 10;
		n /= 10;
	}

	return sum;
}

int main() {
	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		if (n == i + allSum(i)) {
			cout << i;
			exit(0);
		}
	}
	cout << "0";
}