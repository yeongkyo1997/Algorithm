#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int T;
    cin >> T;
    
    while(T--){
        long long x1, y1, r1, x2, y2, r2;
        cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;
        
        // 두 터렛의 중심 간 거리의 제곱 계산
        long long dx = x1 - x2;
        long long dy = y1 - y2;
        long long d_sq = dx * dx + dy * dy;
        
        long long r_sum = r1 + r2;
        long long r_sum_sq = r_sum * r_sum;
        
        long long r_diff = abs(r1 - r2);
        long long r_diff_sq = r_diff * r_diff;
        
        if(d_sq == 0){
            if(r1 == r2){
                cout << "-1\n";
            }
            else{
                cout << "0\n";
            }
        }
        else{
            if(d_sq > r_sum_sq){
                cout << "0\n";
            }
            else if(d_sq == r_sum_sq){
                cout << "1\n";
            }
            else if(d_sq < r_diff_sq){
                cout << "0\n";
            }
            else if(d_sq == r_diff_sq){
                cout << "1\n";
            }
            else{
                cout << "2\n";
            }
        }
    }
    
    return 0;
}