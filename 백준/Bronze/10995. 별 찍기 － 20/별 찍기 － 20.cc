#include <iostream>
#include <vector> // vector 헤더 추가

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(NULL);

    int n;
    std::cin >> n;

    for (int i = 1; i <= n; ++i) {
        if (i % 2 != 0) { // 홀수 줄
            for (int j = 0; j < n; ++j) {
                std::cout << "* ";
            }
        } else { // 짝수 줄
            std::cout << " ";
            for (int j = 0; j < n; ++j) {
                std::cout << "* ";
            }
        }
        std::cout << "\n";
    }

    return 0;
}