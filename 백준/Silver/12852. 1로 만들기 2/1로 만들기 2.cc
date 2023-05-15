#include <iostream>
#include <vector>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    vector<int> dp(N + 2);
    vector<int> trace(N + 2);

    dp[1] = 0;
    trace[1] = -1;

    for (int x = 2; x <= N; x++) {
        dp[x] = dp[x - 1] + 1;
        trace[x] = x - 1;

        if (x % 2 == 0 && dp[x] > dp[x / 2] + 1) {
            dp[x] = dp[x / 2] + 1;
            trace[x] = x / 2;
        }

        if (x % 3 == 0 && dp[x] > dp[x / 3] + 1) {
            dp[x] = dp[x / 3] + 1;
            trace[x] = x / 3;
        }
    }

    int num = dp[N];

    cout << num << "\n";

    int index = N;

    for (int x = 0; x <= num; x++) {
        cout << index << " ";
        index = trace[index];
    }

    cout << endl;

    return 0;
}