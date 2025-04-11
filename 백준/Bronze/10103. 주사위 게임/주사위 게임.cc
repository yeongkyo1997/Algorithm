#include <iostream>
#include <ios>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(NULL);

    int n;
    std::cin >> n;

    int score_c = 100;
    int score_s = 100;

    for (int i = 0; i < n; ++i) {
        int roll_c, roll_s;
        std::cin >> roll_c >> roll_s;
        if (roll_c < roll_s) {
            score_c -= roll_s;
        } else if (roll_s < roll_c) {
            score_s -= roll_c;
        }
    }

    std::cout << score_c << "\n";
    std::cout << score_s << "\n";

    return 0;
}