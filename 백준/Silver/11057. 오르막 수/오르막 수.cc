#include <iostream>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N;
    cin >> N;
    const int MOD = 10007;
    
    int dp[10] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    
    for (int i = 2; i <= N; i++){
        for (int j = 1; j < 10; j++){
            dp[j] = (dp[j] + dp[j-1]) % MOD;
        }
    }
    
    int result = 0;
    for (int j = 0; j < 10; j++){
        result = (result + dp[j]) % MOD;
    }
    
    cout << result << "\n";
    return 0;
}
