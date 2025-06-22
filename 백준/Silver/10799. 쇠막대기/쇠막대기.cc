#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string s;
    cin >> s;

    int openCnt = 0;     // 현재 열려 있는 '(' 개수 = 겹쳐진 쇠막대기 수
    long long pieces = 0;

    for(int i = 0; i < (int)s.size(); i++){
        if(s[i] == '(') {
            // 여는 괄호: 일단 쇠막대기 시작 혹은 레이저 시작 후보
            openCnt++;
        } else {
            // 닫는 괄호
            if(i > 0 && s[i-1] == '(') {
                // 이전이 '(' 이면 레이저 "()"  
                openCnt--;            // 이 레이저 '(' 제거
                pieces += openCnt;    // 겹쳐 있는 모든 쇠막대기를 잘라버림
            } else {
                // 쇠막대기 끝
                openCnt--;            // 해당 쇠막대기의 '(' 제거
                pieces += 1;          // 끝나는 부분이 한 조각
            }
        }
    }

    cout << pieces << "\n";
    return 0;
}