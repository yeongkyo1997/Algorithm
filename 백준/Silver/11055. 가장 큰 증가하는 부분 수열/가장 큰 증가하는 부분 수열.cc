#include <iostream>
#include <vector>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, x;
    cin >> n;

    vector<int> arr(n+1);
    vector<int> dp(n+1);

    for (int i = 1; i <= n; i++) {
        cin >> arr[i];
    }

    for (int i = 1; i <= n; i++) {
        dp[i] = arr[i];
        for (int j = 1; j < i; j++) {
            if (arr[i] > arr[j] && dp[i] < dp[j] + arr[i]) {
                dp[i] = dp[j] + arr[i];
            }
        }
    }

    int max_sum = 0;
    for (int i = 1; i <= n; i++) {
        if (max_sum < dp[i]) {
            max_sum = dp[i];
        }
    }
    cout << max_sum << "\n";

    return 0;
}