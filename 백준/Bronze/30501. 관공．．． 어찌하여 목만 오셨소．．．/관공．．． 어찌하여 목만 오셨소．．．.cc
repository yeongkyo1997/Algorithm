#include <iostream>
#include <string>

void solve() {
    int n;
    std::cin >> n;
    std::string name;
    for (int i = 0; i < n; ++i) {
        std::cin >> name;
        if (name.find('S') != std::string::npos) {
            std::cout << name << std::endl;
            break;
        }
    }
}

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);
    solve();
    return 0;
}