#include <cstdio>
#include <deque>
#include <algorithm>
using namespace std;
 
int main(){
    int T;
    scanf("%d", &T);
    for(int t=0; t<T; t++){
        char P[100001];
        int N;
        deque<int> D;
        scanf("%s %d\n[", P, &N);
        int x = 0;
 
        // 문자 하나 단위로 받아서 수 처리
        while(1){
            char c = getchar();
            // 숫자가 나오면 현재 수*10 한 뒤 더함
            if(c >= '0' && c <= '9') x = x*10 + c-'0';
            // 아닐 경우 현재 수를 덱에 넣음
            else{
                if(x > 0) D.push_back(x);
                x = 0;
                if(c == ']') break;
            }
        }
 
        // 초기에는 에러 없음, 뒤집히지 않은 상태
        bool error = false, rev = false;
        for(int i=0; P[i]; i++){
            // 뒤집기
            if(P[i] == 'R') rev = !rev;
            // 첫 번째 원소 제거
            else{
                // 비어있는데 제거하려 하면 에러
                if(D.empty()){
                    error = true;
                    break;
                }
                if(rev) D.pop_back();
                else D.pop_front();
            }
        }
 
        // 에러가 발생한 경우
        if(error) puts("error");
        // 아닐 경우 덱의 원소를 하나하나 출력
        else{
            putchar('[');
            // 덱이 뒤집힌 상태면 진짜로 뒤집어 준다.
            if(rev) reverse(D.begin(), D.end());
            for(int i=0; i<D.size(); i++){
                printf("%d", D[i]);
                if(i < D.size()-1) putchar(',');
            }
            puts("]");
        }
    }}
