#include <bits/stdc++.h>

using namespace std;

string a, b;
vector<vector<int>> dp;

void input() {
    cin >> a >> b;
}

void pro() {
    int alen = a.length();
    int blen = b.length();

    dp = vector<vector<int>>(alen + 1, vector<int>(blen + 1, 0));

    for (int i = 1; i <= alen; i++) {
        for (int j = 1; j <= blen; j++) {
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
            if (a[i - 1] == b[j - 1]) {
                dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + 1);
            }
        }
    }

    string answer = "";
    int i = alen;
    int j = blen;

    while (i != 0 && j != 0) {
        if (dp[i][j] == dp[i - 1][j]) {
            i--;
        } else if (dp[i][j] == dp[i][j - 1]) {
            j--;
        } else {
            answer = a[i - 1] + answer;
            i--;
            j--;
        }
    }
    cout << dp[alen][blen] << endl;
    cout << answer << endl;
}

int main() {
    input();
    pro();
    return 0;
}