#include <iostream>

using namespace std;

long long int arr[1000] = { 0, };

long long int dfs(int n) {
	if (n == 1 || n == 2) {
		arr[n] = 1;
		return 1;
	}
	else if (arr[n] != 0)
		return arr[n];
	else {
		return arr[n] = dfs(n - 1) + dfs(n - 2);
	}
}

int main() {
	int n;

	cin >> n;

	cout << dfs(n);
}