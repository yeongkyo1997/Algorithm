#include <iostream>
#include <vector>
#include <string>

using namespace std;

int N, M, s, e;
vector<int> num;
vector<vector<bool>> dp;

void dp_cal() {
    for (int i = 1; i <= N; i++) {
        dp[i][i] = true;
    }
    for (int i = 1; i < N; i++) {
        if (num[i] == num[i + 1]) dp[i][i + 1] = true;
    }
    for (int i = 2; i < N; i++) {
        for (int j = 1; j <= N - i; j++) {
            if (num[j] == num[j + i] && dp[j + 1][j + i - 1]) {
                dp[j][j + i] = true;
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N;

    num.resize(N + 1);
    dp.resize(N + 1, vector<bool>(N + 1, false));

    for (int i = 1; i <= N; i++) {
        cin >> num[i];
    }

    dp_cal();

    cin >> M;
    for (int i = 1; i <= M; i++) {
        cin >> s >> e;
        if (dp[s][e]) {
            cout << 1 << "\n";
        } else {
            cout << 0 << "\n";
        }
    }

    return 0;
}