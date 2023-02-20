#include <bits/stdc++.h>
#define endl '\n'
using namespace std;

int gcd(int p, int q) {
	if (q == 0)
		return p;
	return gcd(q, p % q);
}

int main() {
	int n, g, arr[100];
	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> arr[i];
	sort(arr, arr + n);
	
	g = arr[1] - arr[0];

	for (int i = 1; i < n - 1; i++)
		g = gcd(g, arr[i + 1] - arr[i]);
	
	vector<int> v;
	
	for (int i = 1; i * i <= g; i++)
		if (!(g % i)) {
			v.push_back(i);
			if (i != g / i)
				v.push_back(g / i);
		}

	sort(v.begin(), v.end());
	
	for (int& a : v)
		if (a != 1)
			cout << a << ' ';
}