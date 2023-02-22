#include <bits/stdc++.h>
#define endl '\n'
using namespace std;

int recursion(int n) {
	if (n == 1 || n == 0)
		return 1;
	else
		return recursion(n - 1) * n;
}

int main() {
	int n, k;
	cin >> n >> k;
	cout << recursion(n) / (recursion(k) * recursion(n - k));
}