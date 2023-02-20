#include <bits/stdc++.h>
#define endl '\n'
using namespace std;

int n, len, lis[100];
pair<int, int> a[100];

int main() {
	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> a[i].first >> a[i].second;

	sort(a, a + n);

	for (int i = 0; i < n; i++) {
		auto it = std::lower_bound(lis, lis + len, a[i].second);
		if (!(*it)) len++;
		*it = a[i].second;
	}
	cout << n - len;
}