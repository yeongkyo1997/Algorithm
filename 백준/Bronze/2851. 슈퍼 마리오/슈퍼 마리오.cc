#pragma GCC optimize("O3")
#include <iostream>
#include <cmath>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int sum = 0, best = 0;
    for (int i = 0; i < 10; ++i) {
        int x;
        cin >> x;
        sum += x;
        int cur_diff = abs(sum - 100);
        int best_diff = abs(best - 100);
        
        if (cur_diff < best_diff || (cur_diff == best_diff && sum > best)) {
            best = sum;
        }
        if (sum == 100) break;
    }
    cout << best;
}