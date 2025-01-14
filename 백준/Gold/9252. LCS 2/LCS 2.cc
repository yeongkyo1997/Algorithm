#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string A, B;
    cin >> A >> B;

    int N = A.size();
    int M = B.size();

    // DP 배열 준비
    vector<vector<int>> dp(N + 1, vector<int>(M + 1, 0));

    // DP로 LCS 길이 계산
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            if (A[i - 1] == B[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }

    // LCS 길이
    int lcs_length = dp[N][M];
    cout << lcs_length << "\n";

    // 역추적을 통해 실제 LCS 문자열 구성
    string lcs = "";
    int i = N, j = M;
    while (i > 0 && j > 0) {
        if (A[i - 1] == B[j - 1]) {
            lcs += A[i - 1];  // 공통 문자를 추가
            i--;
            j--;
        } else {
            if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
    }

    // 뒤집으면 정방향 LCS가 됨
    reverse(lcs.begin(), lcs.end());

    // LCS 길이가 0이 아니라면 출력
    if (lcs_length > 0) {
        cout << lcs << "\n";
    }

    return 0;
}