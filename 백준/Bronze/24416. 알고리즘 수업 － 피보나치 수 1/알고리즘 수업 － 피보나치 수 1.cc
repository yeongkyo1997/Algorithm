#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")
#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int n;
    cin >> n;
    
    int a = 1, b = 1, code1 = 1;
    for(int i = 3; i <= n; ++i) {
        code1 = a + b;
        b = a;
        a = code1;
    }
    
    cout << code1 << ' ' << n-2;
    return 0;
}