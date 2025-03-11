#include <bits/stdc++.h>
using namespace std;

#pragma GCC optimize("O3")
#pragma GCC target("avx2")

pair<int, int> get_min_max(const string& s) {
    string min_s, max_s;
    for (char c : s) {
        if (c == '5' || c == '6') {
            min_s += '5';
            max_s += '6';
        } else {
            min_s += c;
            max_s += c;
        }
    }
    return {stoi(min_s), stoi(max_s)};
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int A, B;
    cin >> A >> B;
    
    auto a = get_min_max(to_string(A));
    auto b = get_min_max(to_string(B));
    
    cout << a.first + b.first << ' ' << a.second + b.second << '\n';
    
    return 0;
}