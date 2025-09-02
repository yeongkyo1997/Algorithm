#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int HH, MM;
    if (!(cin >> HH >> MM)) return 0;
    cout << (HH - 9) * 60 + MM << '\n';
    return 0;
}