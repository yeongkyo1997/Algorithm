#include <bits/stdc++.h>
using namespace std;
static const int MOD = 9901;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    // dp0, dp1, dp2를 바로 전 열 값으로만 유지
    int dp0 = 1, dp1 = 1, dp2 = 1;

    for(int i = 2; i <= N; i++){
        int ndp0 = ( (dp0 + dp1) % MOD + dp2 ) % MOD;
        int ndp1 = (dp0 + dp2) % MOD;
        int ndp2 = (dp0 + dp1) % MOD;
        dp0 = ndp0; dp1 = ndp1; dp2 = ndp2;
    }

    int ans = ((dp0 + dp1) % MOD + dp2) % MOD;
    cout << ans << "\n";
    return 0;
}