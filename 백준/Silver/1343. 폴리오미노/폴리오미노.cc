#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(NULL);

    std::string board;
    std::cin >> board;

    std::string result = "";
    int count = 0;

    for (int i = 0; i < board.length(); ++i) {
        if (board[i] == 'X') {
            count++;
        } else {
            if (count > 0) {
                if (count % 2 != 0) {
                    std::cout << -1 << "\n";
                    return 0;
                }
                int a_count = count / 4;
                int b_count = (count % 4) / 2;
                for (int j = 0; j < a_count; ++j) {
                    result += "AAAA";
                }
                for (int j = 0; j < b_count; ++j) {
                    result += "BB";
                }
                count = 0;
            }
            result += '.';
        }
    }

    if (count > 0) {
        if (count % 2 != 0) {
            std::cout << -1 << "\n";
            return 0;
        }
        int a_count = count / 4;
        int b_count = (count % 4) / 2;
        for (int j = 0; j < a_count; ++j) {
            result += "AAAA";
        }
        for (int j = 0; j < b_count; ++j) {
            result += "BB";
        }
    }

    std::cout << result << "\n";

    return 0;
}