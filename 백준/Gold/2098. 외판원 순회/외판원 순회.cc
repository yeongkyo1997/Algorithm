#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

const int INF = 0x3f3f3f3f;
int N;
int W[16][16];
int dp[1 << 16][16];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    for (int i = 0; i < N; ++i)
        for (int j = 0; j < N; ++j)
            cin >> W[i][j];

    memset(dp, 0x3f, sizeof(dp));
    dp[1][0] = 0;

    for (int state = 1; state < (1 << N); ++state) {
        for (int current = 0; current < N; ++current) {
            if (!(state & (1 << current))) continue;
            for (int next = 0; next < N; ++next) {
                if (state & (1 << next)) continue;
                if (W[current][next] == 0) continue;
                int next_state = state | (1 << next);
                dp[next_state][next] = min(dp[next_state][next], dp[state][current] + W[current][next]);
            }
        }
    }

    int result = INF;
    int final_state = (1 << N) - 1;
    for (int current = 0; current < N; ++current) {
        if (dp[final_state][current] != INF && W[current][0] != 0)
            result = min(result, dp[final_state][current] + W[current][0]);
    }

    cout << result << '\n';

    return 0;
}