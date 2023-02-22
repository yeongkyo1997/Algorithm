#include <iostream>
#include <cstdio>
using namespace std;

int main() {
	int n;
	int sum = 0;

	cin >> n;
	for (int i = 0; i < n; i++) {
		int num;
		scanf("%1d", &num);
		sum += num;
	}
	cout << sum;
}