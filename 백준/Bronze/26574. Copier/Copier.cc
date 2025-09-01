#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    if (!(cin >> n)) return 0;
    for (int i = 0; i < n; ++i) {
        string s;
        cin >> s;            // 숫자를 문자열로 읽어 그대로 출력
        cout << s << ' ' << s << '\n';
    }
    return 0;
}