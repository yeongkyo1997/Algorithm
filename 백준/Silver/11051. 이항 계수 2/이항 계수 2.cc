#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")
#pragma GCC target("avx,avx2,fma")

#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N, K;
    cin >> N >> K;
    K = min(K, N - K);
    
    int dp[1001][1001] = {0};
    
    for (int i = 0; i <= N; ++i) {
        dp[i][0] = 1;
        if (i >= 1) {
            dp[i][i] = 1;
        }
    }
    
    for (int i = 2; i <= N; ++i) {
        int max_j = min(i - 1, K);
        for (int j = 1; j <= max_j; ++j) {
            dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
        }
    }
    
    cout << dp[N][K] % 10007;
    
    return 0;
}