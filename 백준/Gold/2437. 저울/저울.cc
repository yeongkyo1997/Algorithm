#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    int N;
    cin >> N;
    vector<ll> weights(N);
    for(int i=0;i<N;i++) cin >> weights[i];
    
    // 저울추를 오름차순으로 정렬
    sort(weights.begin(), weights.end());
    
    ll current_max = 0;
    for(int i=0;i<N;i++){
        if(weights[i] > current_max +1){
            break;
        }
        current_max += weights[i];
    }
    
    // 측정할 수 없는 최소 무게는 current_max +1
    cout << current_max +1;
}