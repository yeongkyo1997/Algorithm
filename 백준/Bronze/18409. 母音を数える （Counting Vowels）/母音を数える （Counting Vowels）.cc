#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int N;
    string S;
    if (!(cin >> N >> S)) return 0;
    string vowels = "aiueo";
    int cnt = 0;
    for (char c : S) if (vowels.find(c) != string::npos) cnt++;
    cout << cnt << '\n';
    return 0;
}