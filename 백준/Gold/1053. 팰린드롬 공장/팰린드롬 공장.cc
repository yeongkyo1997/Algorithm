#include <bits/stdc++.h>
using namespace std;

/*
 * 편집연산(#1~#3만 사용)으로 문자열 s를 팰린드롬으로 만들 때 드는
 * 최소 연산 횟수를 DP로 구한다.
 *  - 삽입, 삭제, 교체 연산만 고려
 *  - DP 복잡도: O(n^2) (n은 문자열 길이)
 */
int palindromeEditDistance(const string &s) {
    int n = (int)s.size();
    // dp[i][j]: s[i..j] 구간을 팰린드롬으로 만들기 위한 최소 연산 수
    vector<vector<int>> dp(n, vector<int>(n, 0));

    // 부분 길이 1은 이미 팰린드롬, 비용 0
    // 부분 길이 2 이상부터 점진적으로 채움
    for(int length = 2; length <= n; length++){
        for(int i = 0; i + length - 1 < n; i++){
            int j = i + length - 1;
            // 양 끝 문자가 같은 경우
            if(s[i] == s[j]){
                dp[i][j] = dp[i+1][j-1];
            } else {
                // 1) s[i]를 삭제(또는 s[j]에 삽입) -> dp[i+1][j] + 1
                // 2) s[j]를 삭제(또는 s[i]에 삽입) -> dp[i][j-1] + 1
                // 3) s[i]를 s[j]로 교체(혹은 그 반대) -> dp[i+1][j-1] + 1
                dp[i][j] = 1 + min({
                    dp[i+1][j],     // 삭제 i or 삽입 j
                    dp[i][j-1],     // 삭제 j or 삽입 i
                    dp[i+1][j-1]    // 교체
                });
            }
        }
    }
    return dp[0][n-1];
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    string s;
    cin >> s;
    int n = (int)s.size();

    // 먼저, 교환 연산(#4) 없이 최소 편집 거리 계산
    int costNoSwap = palindromeEditDistance(s);
    int answer = costNoSwap;

    // 길이가 0 또는 1인 경우 이미 팰린드롬이므로 비용 0
    if(n <= 1){
        cout << 0 << "\n";
        return 0;
    }

    // 교환 연산(#4)을 "최대 한 번" 사용할 경우를 모두 시도
    // 서로 다른 두 문자 위치 (i, j)에 대해 swap 시도
    for(int i = 0; i < n; i++){
        for(int j = i+1; j < n; j++){
            if(s[i] != s[j]){
                // i, j 서로 교환
                swap(s[i], s[j]);
                // 삽입/삭제/교체 편집 거리 재계산
                int costAfterSwap = palindromeEditDistance(s);
                // 교환 1회 비용 + 그 후 편집 비용
                answer = min(answer, 1 + costAfterSwap);
                // 원상복구
                swap(s[i], s[j]);
            }
        }
    }

    // 결과 출력
    cout << answer << "\n";
    return 0;
}