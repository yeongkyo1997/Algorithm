#include <iostream>
#include <vector>
#include <algorithm>

int count[2000001];

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(NULL);

    int n; 
    std::cin >> n;

    int offset = 1000000; 

    for (int i = 0; i < n; ++i) {
        int num;
        std::cin >> num;
        count[num + offset]++;
    }

    for (int i = 0; i <= 2000000; ++i) {
        for (int j = 0; j < count[i]; ++j) {
             std::cout << (i - offset) << '\n';
        }
    }

    return 0;
}