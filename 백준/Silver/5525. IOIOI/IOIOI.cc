#include <iostream>
#include <string>

int main() {
    int N, M, answer = 0, i = 0, count = 0;
    std::string S;

    std::cin >> N;
    std::cin >> M;
    std::cin >> S;

    while (i < (M - 1)) {
        if (S.substr(i, 3) == "IOI") {
            i += 2;
            count += 1;
            if (count == N) {
                answer += 1;
                count -= 1;
            }
        } else {
            i += 1;
            count = 0;
        }
    }

    std::cout << answer << std::endl;

    return 0;
}