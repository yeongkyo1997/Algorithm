#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")
#pragma GCC target("avx,avx2,fma")

#include <iostream>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N;
    cin >> N;
    cin.ignore();
    
    while (N--) {
        string s;
        getline(cin, s);
        cout << (s.size() >= 6 && s.size() <= 9 ? "yes\n" : "no\n");
    }
}