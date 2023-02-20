#include <bits/stdc++.h>
#define endl '\n'
using namespace std;

const int MAX = 1000 + 1;
const int MOD = 10007;
int N, K;
int DP[MAX][MAX];

int recursion(int n, int k) {

	if (n == k || k == 0) return 1;

	int& ret = DP[n][k];

	if (ret != -1)
		return ret;

	return ret = ((recursion(n - 1, k) + recursion(n - 1, k - 1))) % MOD;

}

int main() {

	memset(DP, -1, sizeof(DP));

	cin >> N >> K;

	int result = recursion(N, K);

	cout << result << endl;
}