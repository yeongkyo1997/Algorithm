#include <iostream>
#include <sstream>
#include <string>

int main() {
    std::string S;
    std::getline(std::cin, S);

    std::stringstream ss(S);
    std::string token;
    int sum = 0;

    while (std::getline(ss, token, ',')) {
        sum += std::stoi(token);
    }

    std::cout << sum << std::endl;

    return 0;
}