#include <iostream>
#include <string>
#include <vector>

void solve() {
    std::string isbn;
    std::cin >> isbn;

    int sum = 0;
    int star_index = -1;

    for (int i = 0; i < 13; ++i) {
        if (isbn[i] == '*') {
            star_index = i;
            continue;
        }

        int digit = isbn[i] - '0';
        int weight = (i % 2 == 0) ? 1 : 3;
        sum += digit * weight;
    }

    int star_weight = (star_index % 2 == 0) ? 1 : 3;

    for (int i = 0; i <= 9; ++i) {
        if ((sum + i * star_weight) % 10 == 0) {
            std::cout << i << std::endl;
            return;
        }
    }
}

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);
    solve();
    return 0;
}