#include <iostream>

using namespace std;


int main () {
	long long int arr[91] = {0, };
	int n;

	arr[1] = arr[2] = 1;
	
	cin >> n;

	for (int i = 3; i <= n; i++) {
		arr[i] = arr[i - 1] + arr[i - 2];
	}

	cout << arr[n];
}