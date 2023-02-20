#include <iostream>
#include <vector>
#include <cstring>
#include <cmath>
#include <algorithm>

#define MAX 1120

using namespace std;

bool isPrime[MAX + 1];
vector<int> prime;
int dp[MAX + 1][15];

void eratosthenes() {
	memset(isPrime, 1, sizeof(isPrime));
	isPrime[0] = isPrime[1] = 0;
	int sqrtn = int(sqrt(MAX));

	for (int i = 2; i <= sqrtn; i++) {
		if (isPrime[i]) {
			for (int j = i * i; j <= MAX; j += i) {
				isPrime[j] = 0;
			}
		}
	}
	for (int i = 2; i <= MAX; i++) {
		if (isPrime[i])
			prime.push_back(i);
	}
}
int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	eratosthenes();
	dp[0][0] = 1;

	for (int i = 0; i < prime.size(); i++) {
		for (int j = MAX; j >= prime[i]; j--) {
			for (int k = 1; k < 15; k++) {
				dp[j][k] += dp[j - prime[i]][k - 1];
			}
		}
	}
	int tc, n, k;
	cin >> tc;
	while (tc--) {
		cin >> n >> k;
		cout << dp[n][k] << endl;
	}
	return 0;
}
