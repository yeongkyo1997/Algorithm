#include <iostream>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(NULL);
    int n;
    std::cin >> n;
    long long sum = (long long)n * (n + 1) / 2;
    std::cout << sum << "\n";
    return 0;
}