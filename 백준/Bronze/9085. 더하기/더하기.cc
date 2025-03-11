#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")
#pragma GCC target("avx,avx2,fma")
#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int T;
    cin >> T;
    
    while(T--) {
        int N;
        cin >> N;
        
        int sum = 0;
        while(N--) {
            int num;
            cin >> num;
            sum += num;
        }
        cout << sum << '\n';
    }
    
    return 0;
}