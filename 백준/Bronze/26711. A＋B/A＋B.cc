#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,avx2,fma")
#include <bits/stdc++.h>
using namespace std;

string addStrings(const string& a, const string& b) {
    string result;
    int carry = 0;
    int i = a.length() - 1, j = b.length() - 1;
    
    while (i >= 0 || j >= 0 || carry > 0) {
        int sum = carry;
        if (i >= 0) sum += a[i--] - '0';
        if (j >= 0) sum += b[j--] - '0';
        
        carry = sum / 10;
        result.push_back(sum % 10 + '0');
    }
    
    reverse(result.begin(), result.end());
    return result;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    string a, b;
    getline(cin, a);
    getline(cin, b);
    
    cout << addStrings(a, b) << '\n';
    return 0;
}