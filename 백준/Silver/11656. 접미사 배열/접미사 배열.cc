#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")
#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    string s;
    cin >> s;
    
    vector<string> suffixes;
    suffixes.reserve(s.size());
    
    for (size_t i = 0; i < s.size(); ++i) {
        suffixes.emplace_back(s.substr(i));
    }
    
    sort(suffixes.begin(), suffixes.end());
    
    for (const auto& suffix : suffixes) {
        cout << suffix << '\n';
    }
    
    return 0;
}