#include <bits/stdc++.h>
using namespace std;

static const long long MOD = 1000000007;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N; 
    cin >> N;
    vector<long long> arr(N);
    for(int i = 0; i < N; i++){
        cin >> arr[i];
    }
    sort(arr.begin(), arr.end());  // 오름차순 정렬

    // 미리 2의 거듭제곱을 계산해 둠
    vector<long long> pow2(N);
    pow2[0] = 1;
    for(int i = 1; i < N; i++){
        pow2[i] = (pow2[i-1] * 2) % MOD;
    }

    long long answer = 0;
    // i번째 원소가 최댓값으로 기여하는 부분(+)와
    // i번째 원소가 최솟값으로 기여하는 부분(-)을 더함
    for(int i = 0; i < N; i++){
        // arr[i] * 2^i
        long long plusTerm = (arr[i] % MOD) * (pow2[i] % MOD) % MOD;
        // arr[i] * 2^(N-1-i)
        long long minusTerm = (arr[i] % MOD) * (pow2[N-1-i] % MOD) % MOD;
        answer = (answer + plusTerm - minusTerm + MOD) % MOD; 
        // (중간 계산에서 음수가 될 수 있으므로 MOD를 더해 보정)
    }

    cout << answer % MOD << "\n";
    return 0;
}