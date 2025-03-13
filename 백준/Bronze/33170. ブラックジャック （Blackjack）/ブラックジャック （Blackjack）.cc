#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")
#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    int A, B, C;
    cin >> A >> B >> C;
    cout << (A + B + C <= 21) << '\n';
    return 0;
}
