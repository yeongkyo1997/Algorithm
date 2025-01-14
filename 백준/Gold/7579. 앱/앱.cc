#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M; 
    cin >> N >> M;

    vector<int> memory(N), cost(N);
    for (int i = 0; i < N; i++) {
        cin >> memory[i];
    }
    for (int i = 0; i < N; i++) {
        cin >> cost[i];
    }

    // 최대 비용(모든 앱의 비용 합)은 최대 N * 100
    int maxCost = 100 * N;

    // dp[c] = 비용 c로 확보할 수 있는 최대 메모리
    // 초기값은 -1(불가능 상태)로 두고, dp[0] = 0으로 시작
    vector<long long> dp(maxCost + 1, -1);
    dp[0] = 0;

    // 각 앱에 대해, 비용을 기준으로 DP 테이블 갱신
    for (int i = 0; i < N; i++) {
        int c = cost[i];
        long long mem = memory[i];
        
        // 큰 비용부터 갱신해야 이전 상태를 덮어쓰지 않음
        for (int curCost = maxCost; curCost >= c; curCost--) {
            if (dp[curCost - c] != -1) {
                dp[curCost] = max(dp[curCost], dp[curCost - c] + mem);
            }
        }
    }

    // 필요한 메모리 M 이상을 만족하는 최소 비용 찾기
    int answer = 0;
    for (; answer <= maxCost; answer++) {
        if (dp[answer] >= M) {
            cout << answer << "\n";
            break;
        }
    }

    return 0;
}