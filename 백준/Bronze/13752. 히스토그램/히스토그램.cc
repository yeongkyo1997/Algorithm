#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(NULL);

    int n;
    std::cin >> n;

    while (n--) {
        int k;
        std::cin >> k;
        std::string histogram_bar(k, '=');
        std::cout << histogram_bar << '\n';
    }

    return 0;
}