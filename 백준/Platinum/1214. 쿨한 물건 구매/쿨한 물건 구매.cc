#include <iostream>
#include <algorithm>
#include <climits>
using namespace std;

typedef long long ll;

int main() {
    ll D, P, Q;
    cin >> D >> P >> Q;
    
    // P를 Q보다 크게 만듭니다.
    if (P < Q) swap(P, Q);
    
    ll min_val = LLONG_MAX;
    
    // P 또는 Q 단독으로 사용한 경우 계산
    ll candidateP = (D + P - 1) / P * P;
    ll candidateQ = (D + Q - 1) / Q * Q;
    min_val = min(candidateP, candidateQ);
    
    // Q의 범위를 최소화하기 위해 최대 a는 Q까지로 제한
    ll max_a = min((D + P) / P, Q);
    for (ll a = 0; a <= max_a; ++a) {
        ll remain = D - a * P;
        ll b = (remain <= 0) ? 0 : (remain + Q - 1) / Q;
        ll total = a * P + b * Q;
        if (total < min_val) {
            min_val = total;
        }
    }
    
    cout << min_val << endl;
    return 0;
}