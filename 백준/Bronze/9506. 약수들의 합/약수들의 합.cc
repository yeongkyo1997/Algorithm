#include<iostream>
#include<vector>
#include<cstdio>
 
using namespace std;
 
bool Solution(vector<int>& v, int n){
    int sum=0;
    for(int i=1; i<n ; i++){    //약수 구하기 a
        if(n%i ==0){
            v.push_back(i);
            sum+=i;
        }
    }
 
    return sum == n;
}
 
int main(void){
 
    int n;
    while(true){
        cin >> n;           //입력
        if(n == -1) break;  //종료조건
 
        vector<int> v;
 
        if(Solution(v, n)){ //출력
            printf("%d = ", n);
            for(int i=0; i<v.size(); i++){
                printf("%d ", v[i]);
 
                if(i != v.size() -1) printf("+ ");
            }
            printf("\n");
 
        }else{
            printf("%d is NOT perfect.\n", n);
        }
 
    }
 
    return 0;
}
