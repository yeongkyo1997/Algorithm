#include <iostream>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    long long w, h;
    std::cin >> w >> h;

    long long p, q;
    std::cin >> p >> q;

    long long t;
    std::cin >> t;

    long long final_x, final_y;

    long long effective_pos_x = p + t;
    long long folded_pos_x = effective_pos_x % (2 * w);
    if (folded_pos_x > w) {
        final_x = 2 * w - folded_pos_x;
    } else {
        final_x = folded_pos_x;
    }

    long long effective_pos_y = q + t;
    long long folded_pos_y = effective_pos_y % (2 * h);
    if (folded_pos_y > h) {
        final_y = 2 * h - folded_pos_y;
    } else {
        final_y = folded_pos_y;
    }

    std::cout << final_x << " " << final_y << std::endl;

    return 0;
}