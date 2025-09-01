#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    string s;
    if (!(cin >> s)) return 0;
    if (s == "M") cout << "MatKor\n";
    else if (s == "W") cout << "WiCys\n";
    else if (s == "C") cout << "CyKor\n";
    else if (s == "A") cout << "AlKor\n";
    else if (s == "$") cout << "$clear\n";
    return 0;
}