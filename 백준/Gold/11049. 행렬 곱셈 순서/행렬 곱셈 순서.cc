#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    vector<vector<int>> graph(N, vector<int>(2));
    for(int i = 0; i < N; ++i) {
        cin >> graph[i][0] >> graph[i][1];
    }

    vector<vector<int>> dp(N, vector<int>(N, 0));

    for(int i = 1; i < N; ++i) {
        for(int j = 0; j < N - i; ++j) {
            int x = j + i;
            dp[j][x] = INT_MAX;
            for(int k = j; k < x; ++k) {
                dp[j][x] = min(dp[j][x], dp[j][k] + dp[k+1][x] + 
                               graph[j][0] * graph[k][1] * graph[x][1]);
            }
        }
    }

    cout << dp[0][N-1];

    return 0;
}