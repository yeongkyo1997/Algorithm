#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")
#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int total, sum = 0;
    cin >> total;
    
    for (int i = 0; i < 9; ++i) {
        int price;
        cin >> price;
        sum += price;
    }
    
    cout << total - sum << '\n';
    return 0;
}