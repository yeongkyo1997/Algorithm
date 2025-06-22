#include <iostream>
#include <vector>
#include <algorithm>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    int n;
    std::cin >> n;

    std::vector<int> expected_ranks(n);
    for (int i = 0; i < n; ++i) {
        std::cin >> expected_ranks[i];
    }

    std::sort(expected_ranks.begin(), expected_ranks.end());

    long long total_dissatisfaction = 0;
    for (int i = 0; i < n; ++i) {
        long long expected = expected_ranks[i];
        long long actual = i + 1;
        
        if (expected > actual) {
            total_dissatisfaction += (expected - actual);
        } else {
            total_dissatisfaction += (actual - expected);
        }
    }

    std::cout << total_dissatisfaction << std::endl;

    return 0;
}