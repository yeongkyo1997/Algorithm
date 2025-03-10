#pragma GCC optimize("O3")
#pragma GCC optimize("Ofast")
#pragma GCC optimize("unroll-loops")
#include <iostream>
#include <string>
using namespace std;

bool isPalindrome(int n) {
    string s = to_string(n);
    int len = s.length();
    for (int i = 0; i < len/2; ++i) {
        if (s[i] != s[len-1-i]) return false;
    }
    return true;
}

bool isPrime(int n) {
    if (n <= 1) return false;
    if (n == 2) return true;
    if (n%2 == 0) return false;
    for (int i = 3; i*i <= n; i += 2) {
        if (n%i == 0) return false;
    }
    return true;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N;
    cin >> N;
    
    for (int i = N; ; ++i) {
        if (!isPalindrome(i)) continue;
        if (i > 2 && i%2 == 0) continue;
        if (isPrime(i)) {
            cout << i;
            break;
        }
    }
}