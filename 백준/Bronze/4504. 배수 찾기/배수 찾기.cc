#include <iostream>
using namespace std;

int k;
int main() {
	int n;
	cin >> k;
	while (1) {
		cin >> n;
		if (n == 0)
			break;
		if (n % k == 0)
			printf("%d is a multiple of %d.\n", n, k);
		else
			printf("%d is NOT a multiple of %d.\n", n, k);
	}
	return 0;
}