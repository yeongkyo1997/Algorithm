#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    long long A, B, C;
    if (!(cin >> A >> B >> C)) return 0;
    cout << (A + B == C ? "correct!" : "wrong!");
    return 0;
}