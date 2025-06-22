#include <iostream>
#include <vector>
#include <algorithm>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    int n;
    std::cin >> n;

    std::vector<int> l(n);
    std::vector<int> j(n);

    int free_joy = 0;

    for (int i = 0; i < n; ++i) {
        std::cin >> l[i];
    }
    for (int i = 0; i < n; ++i) {
        std::cin >> j[i];
        if (l[i] == 0 && j[i] > 0) {
            free_joy += j[i];
        }
    }

    std::vector<int> dp(100, 0);

    for (int i = 0; i < n; ++i) {
        int health_loss = l[i];
        int joy_gain = j[i];

        if (health_loss == 0 || health_loss >= 100) {
            continue;
        }

        for (int k = 99; k >= health_loss; --k) {
            dp[k] = std::max(dp[k], dp[k - health_loss] + joy_gain);
        }
    }

    int max_dp_joy = 0;
    for (int k = 0; k < 100; ++k) {
        max_dp_joy = std::max(max_dp_joy, dp[k]);
    }

    std::cout << free_joy + max_dp_joy << std::endl;

    return 0;
}