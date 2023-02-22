#include<iostream>
using namespace std;
 
int n, d[101][11];
long long ans = 0;
 
int main(void){
    cin >> n;
    for (int i = 1; i < 10; i++) d[1][i] = 1;
    for (int i = 2; i <= n; i++){
        for (int j = 0; j < 10; j++){
            d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]) % 1000000000;
        }
    }
    for (int i = 0; i < 10; i++) ans += d[n][i];
    cout << ans % 1000000000 << "\n";
    return 0;
}