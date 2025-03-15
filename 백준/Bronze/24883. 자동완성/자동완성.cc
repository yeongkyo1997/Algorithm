#include <iostream>

int main() {
    char c;
    std::cin >> c;
    
    if (c == 'N' || c == 'n') {
        std::cout << "Naver D2" << std::endl;
    } else {
        std::cout << "Naver Whale" << std::endl;
    }
    
    return 0;
}