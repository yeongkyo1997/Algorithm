#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    if (!(cin >> N)) return 0;
    while (N--) {
        long long A, B, X;
        cin >> A >> B >> X;
        cout << A * (X - 1) + B << '\n';
    }
    return 0;
}