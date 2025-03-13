#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")
#include <iostream>
#include <cstring>
#include <utility> // Required for std::pair

using namespace std;

int recursion(const char* s, int l, int r, int& cnt) {
    cnt++;
    if (l >= r) return 1;
    else if (s[l] != s[r]) return 0;
    else return recursion(s, l + 1, r - 1, cnt);
}

pair<int, int> isPalindrome(const char* s) {
    int cnt = 0;
    int res = recursion(s, 0, strlen(s) - 1, cnt);
    return {res, cnt};
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;
    while (T--) {
        string s;
        cin >> s;
        pair<int, int> result = isPalindrome(s.c_str());
        cout << result.first << ' ' << result.second << '\n';
    }
}