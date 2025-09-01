#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    long long H, I, A, R, C;
    if (!(cin >> H >> I >> A >> R >> C)) return 0;
    cout << H * I - A * R * C << '\n';
    return 0;
}