#include <iostream>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    int n;
    std::cin >> n;

    bool dp[5];

    dp[0] = false; 

    for (int i = 1; i <= n; ++i) {
        int current_idx = i % 5;
        bool can_win = false;

        if (i >= 1) {
            if (!dp[(i - 1) % 5]) {
                can_win = true;
            }
        }

        if (i >= 3) {
            if (!dp[(i - 3) % 5]) {
                can_win = true;
            }
        }

        if (i >= 4) {
            if (!dp[(i - 4) % 5]) {
                can_win = true;
            }
        }
        
        dp[current_idx] = can_win;
    }

    if (dp[n % 5]) {
        std::cout << "SK\n";
    } else {
        std::cout << "CY\n";
    }

    return 0;
}