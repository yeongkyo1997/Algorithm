#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int p, q, r, s;
    cout << fixed << setprecision(5);
    // 입력이 더 이상 없을 때까지 반복
    while ( (cin >> p >> q >> r >> s) ){
        double res = 1.0;
        int Q = max(q, s);
        // i=1..Q 에서
        //  - i<=q: res *= (p-q+i)/i      〈— binom(p,q)의 곱 항
        //  - i<=s: res *= i/(r-s+i)      〈— binom(r,s)의 분모 항을 나눔
        for (int i = 1; i <= Q; i++){
            if (i <= q) {
                res *= (double)(p - q + i) / i;
            }
            if (i <= s) {
                res *= (double)i / (r - s + i);
            }
        }
        cout << res << "\n";
    }

    return 0;
}
