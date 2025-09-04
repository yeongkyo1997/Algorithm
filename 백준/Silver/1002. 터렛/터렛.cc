#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int T; 
    if (!(cin >> T)) return 0;
    while (T--) {
        long long x1, y1, r1, x2, y2, r2;
        cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;
        long long dx = x1 - x2;
        long long dy = y1 - y2;
        long long d2 = dx*dx + dy*dy; // 중심 거리의 제곱
        if (d2 == 0) {
            if (r1 == r2) cout << -1 << '\n';
            else cout << 0 << '\n';
            continue;
        }
        long long sumR = r1 + r2, diffR = llabs(r1 - r2);
        long long sumR2 = sumR * sumR, diffR2 = diffR * diffR;
        if (d2 > sumR2 || d2 < diffR2) cout << 0 << '\n';
        else if (d2 == sumR2 || d2 == diffR2) cout << 1 << '\n';
        else cout << 2 << '\n';
    }
    return 0;
}