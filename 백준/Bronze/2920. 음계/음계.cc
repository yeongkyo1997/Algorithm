#include<iostream>
#include<cstdio>
#define LEN 8
enum {ASC=0, DESC, MIXED};
using namespace std;
 
int main(void){
    int result=0;
    int arr[LEN];
 
    for(int i=0; i<LEN; i++){
        scanf("%d", &arr[i]);
    }
 
    //초기 값 정해주기
    if(arr[1]-arr[0] == 1)result = ASC;
    else if(arr[1]-arr[0] == -1)result = DESC;
    else result = MIXED;
 
    //이전 값과 같은지 아닌지
    for(int i=1; i<LEN-1; i++){
        if(arr[i+1]-arr[i] == 1 && result == ASC) continue;
        if(arr[i+1]-arr[i] == -1 && result == DESC) continue;
 
        result = MIXED;
        break;
    }
 
    
    if(result == ASC) cout << "ascending";
    else if(result == DESC) cout << "descending";
    else cout << "mixed";
 
    return 0;
}
