#include <iostream>
#include <vector>
#include <numeric>

void solve() {
    int n, m;

    std::cin >> n;

    std::vector<long long> prefix_sum(n + 1, 0);
    for (int i = 1; i <= n; ++i) {
        int num;
        std::cin >> num;
        prefix_sum[i] = prefix_sum[i - 1] + num;
    }

    std::cin >> m;

    for (int k = 0; k < m; ++k) {
        int i, j;
        std::cin >> i >> j;
        long long result = prefix_sum[j] - prefix_sum[i - 1];
        std::cout << result << "\n";
    }
}

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);
    solve();
    return 0;
}