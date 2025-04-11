#include <iostream>
#include <string>
#include <vector>
#include <cmath>
#include <numeric>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(NULL);

    std::string word1, word2;
    std::cin >> word1 >> word2;

    int freq1[26] = {0};
    int freq2[26] = {0};

    for (char c : word1) {
        if (c >= 'a' && c <= 'z') {
            freq1[c - 'a']++;
        }
    }
    for (char c : word2) {
         if (c >= 'a' && c <= 'z') {
            freq2[c - 'a']++;
        }
    }

    int removed_count = 0;
    for (int i = 0; i < 26; ++i) {
        removed_count += std::abs(freq1[i] - freq2[i]);
    }

    std::cout << removed_count << "\n";

    return 0;
}