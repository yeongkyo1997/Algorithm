#include <iostream>
#include <vector>
#include <iterator>
#include <algorithm>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    int n;
    std::cin >> n;

    std::vector<int> line;
    line.reserve(n);

    for (int i = 1; i <= n; ++i) {
        int k;
        std::cin >> k;
        auto it = line.begin() + (line.size() - k);
        line.insert(it, i);
    }

    for (int i = 0; i < n; ++i) {
        std::cout << line[i] << (i == n - 1 ? "" : " ");
    }
    std::cout << std::endl;

    return 0;
}