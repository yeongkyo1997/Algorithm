#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    long long N, A, B;
    if (!(cin >> N >> A >> B)) return 0;
    if (A < B) cout << "Bus\n";
    else if (A > B) cout << "Subway\n";
    else cout << "Anything\n";
    return 0;
}