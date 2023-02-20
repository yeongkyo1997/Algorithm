#include <iostream>

using namespace std;

long long int fib(int n, long long int arr[]) {
	if (n == 1 || n == 2 || n == 3)
		return 1;
	else if (arr[n] > 0)
		return arr[n];
	else {
		arr[n] = fib(n - 2, arr) + fib(n - 3, arr);
		return arr[n];
	}
	
}

int main() {
	int n;
	int size;
	

	cin >> size;
	
	for (int i = 0; i < size; i++) {
		cin >> n;
		long long int arr[1000] = { 0, };
		cout << fib(n, arr) << "\n";

	}
}