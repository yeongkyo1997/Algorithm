#include <iostream>
#include <vector>
#include <numeric>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    int m;
    std::cin >> m;

    long long current_sum = 0;
    long long current_xor_sum = 0;

    for (int i = 0; i < m; ++i) {
        int type;
        std::cin >> type;

        if (type == 1) {
            long long x;
            std::cin >> x;
            current_sum += x;
            current_xor_sum ^= x;
        } else if (type == 2) {
            long long x;
            std::cin >> x;
            current_sum -= x;
            current_xor_sum ^= x;
        } else if (type == 3) {
            std::cout << current_sum << "\n";
        } else if (type == 4) {
            std::cout << current_xor_sum << "\n";
        }
    }

    return 0;
}