#include <iostream>
#include <string>
#include <map>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    int n;
    std::cin >> n;

    std::map<std::string, int> counts;
    for (int i = 0; i < n; ++i) {
        std::string title;
        std::cin >> title;
        counts[title]++;
    }

    int max_freq = 0;
    std::string best_title = "";

    for (const auto& pair : counts) {
        const std::string& title = pair.first;
        int freq = pair.second;

        if (freq > max_freq) {
            max_freq = freq;
            best_title = title;
        }
    }

    std::cout << best_title << std::endl;

    return 0;
}