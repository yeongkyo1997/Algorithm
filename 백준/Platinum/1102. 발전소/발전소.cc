#include <cstdio>
#include <cstring>
#include <climits>
#include <algorithm>
#include <iostream>
using namespace std;

int n, p, i, j, cur, full;
int cost[16][16];
int dp[1 << 16];
char str[17];

int func(int num, int stat) {
	if (num == p)
		return 0;

	int& ref = dp[stat];
	if (ref != -1)
		return ref;

	ref = INT_MAX;

	for (int from = 0; from < n; ++from) {
		if (stat & (1 << from)) {
			for (int to = 0; to < n; ++to) {
				if (from == to)
					continue;

				if ((stat & (1 << to)) == 0)
					ref = min(ref, func(num + 1, stat | (1 << to)) + cost[from][to]);
			}
		}
	}

	return ref;
}

int main() {
	memset(dp, -1, sizeof(dp));

	cin >> n;

	full = (1 << n) - 1;
	for (i = 0; i < n; ++i)
		for (j = 0; j < n; ++j)
			cin >> cost[i][j];

	scanf("%s %d", str, &p);

	int cnt = 0;
	for (i = 0; i < n; ++i) {
		if (str[i] == 'Y') {
			cur = cur | (1 << i);
			cnt++;
		}
	}

	if (cnt == 0) {
		if (p == 0)
			cout << "0" << endl;
		else
			cout << "-1" << endl;
	}
	else if (cnt >= p)
		cout << "0" << endl;

	else
		cout << func(cnt, cur);

	return 0;
}
