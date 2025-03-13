#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")
#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    int A, B;
    cin >> A >> B;
    cout << B - A << ' ' << B << '\n';
    return 0;
}