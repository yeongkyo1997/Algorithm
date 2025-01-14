#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int a, b, c;
    cin >> a >> b >> c;
    
    // 세 각의 합 계산
    int sum = a + b + c;
    
    if(sum != 180){
        cout << "Error\n";
    }
    else{
        if(a == 60 && b == 60 && c == 60){
            cout << "Equilateral\n";
        }
        else{
            // 두 각이 같은지 확인
            if(a == b || b == c || a == c){
                cout << "Isosceles\n";
            }
            else{
                cout << "Scalene\n";
            }
        }
    }
    
    return 0;
}