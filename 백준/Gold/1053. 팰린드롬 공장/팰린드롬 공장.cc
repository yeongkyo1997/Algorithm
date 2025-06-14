#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int minEdit(string s) {
    int n = s.size();
    int dp[51][51] = {0};

    for (int len = 2; len <= n; ++len) {
        for (int i = 0; i + len - 1 < n; ++i) {
            int j = i + len - 1;
            if (s[i] == s[j]) {
                dp[i][j] = dp[i+1][j-1];
            } else {
                dp[i][j] = min({dp[i+1][j] + 1, dp[i][j-1] + 1, dp[i+1][j-1] + 1});
            }
        }
    }
    return dp[0][n-1];
}

int main() {
    string s;
    cin >> s;
    int ans = minEdit(s);

    // swap을 한 번도 안 쓴 경우(ans)와, 한 번 쓴 경우(모든 swap 시도) 중 최소값
    int n = s.size();
    for (int i = 0; i < n; ++i) {
        for (int j = i+1; j < n; ++j) {
            if (s[i] != s[j]) {
                swap(s[i], s[j]);
                ans = min(ans, minEdit(s) + 1); // swap 1회 사용
                swap(s[i], s[j]);
            }
        }
    }
    cout << ans << endl;
    return 0;
}