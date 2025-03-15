#include <iostream>

int main() {
    int n1, n2, n12;
    std::cin >> n1 >> n2 >> n12;
    int result = ((n1 + 1) * (n2 + 1) / (n12 + 1)) - 1;
    std::cout << result << std::endl;
    return 0;
}