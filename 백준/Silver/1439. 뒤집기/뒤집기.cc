#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    string S;
    cin >> S;
    
    if(S.empty()){
        cout << "0\n";
        return 0;
    }
    
    int count_0 = 0, count_1 = 0;
    char prev = S[0];
    
    // 초기 그룹 카운트
    if(prev == '0') count_0++;
    else if(prev == '1') count_1++;
    
    // 문자열을 순회하며 그룹 수 세기
    for(int i = 1; i < S.size(); i++){
        if(S[i] != prev){
            if(S[i] == '0') count_0++;
            else if(S[i] == '1') count_1++;
            prev = S[i];
        }
    }
    
    // 최소 연산 횟수 출력
    cout << min(count_0, count_1) << "\n";
    
    return 0;
}