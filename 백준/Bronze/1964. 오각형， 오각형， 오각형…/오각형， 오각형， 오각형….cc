#include <iostream>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(NULL);

    long long n;
    std::cin >> n;

    long long numerator = 3 * n % 91356 * n % 91356 + 5 * n % 91356 + 2;
    numerator %= 91356; 


    long long result = (numerator / 2) % 45678;

    std::cout << result << "\n";

    return 0;
}