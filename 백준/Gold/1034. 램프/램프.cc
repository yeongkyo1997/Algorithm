#include <bits/stdc++.h>
using namespace std;

int n, m, k;
char lamp[51][51];
int searchArr[51];

int main(void) {
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++)
		scanf("%s", lamp[i]);
	scanf("%d", &k);

	vector<long long> v;

	for (int i = 0; i < n; i++) {
		long long tmp = 0;
		int num = 0;
		for (int j = 0; j < m; j++) {
			tmp = 2 * tmp + (lamp[i][j] - '0');
			num += (lamp[i][j] == '0');
		}
		if (num > k || (k - num) % 2 != 0)
			continue;
		v.push_back(tmp);
	}
	sort(v.begin(), v.end());
	if (v.empty()) {
		printf("0");
		return 0;
	}
	searchArr[0] = 1;
	int mx = 1;

	for (int i = 1; i < v.size(); i++) {
		if (v[i] == v[i - 1]) {
			searchArr[i] = searchArr[i - 1] + 1;
			mx = max(mx, searchArr[i]);
		}
		else
			searchArr[i] = 1;
	}
	printf("%d", mx);
}