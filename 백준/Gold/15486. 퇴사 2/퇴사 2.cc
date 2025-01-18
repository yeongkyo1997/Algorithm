#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    vector<vector<pair<int, int>>> end_to_consultations(N + 1);

    for (int k = 1; k <= N; k++) {
        int Ti, Pi;
        cin >> Ti >> Pi;
        int end_day = k + Ti - 1;
        if (end_day <= N) {
            end_to_consultations[end_day].push_back({k, Pi});
        }
    }

    vector<int> dp(N + 1, 0);

    for (int k = 1; k <= N; k++) {
        dp[k] = dp[k - 1];
        for (const auto& consultation : end_to_consultations[k]) {
            int s = consultation.first;
            int Pi = consultation.second;
            dp[k] = max(dp[k], dp[s - 1] + Pi);
        }
    }

    cout << dp[N] << endl;

    return 0;
}