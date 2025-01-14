#include <bits/stdc++.h>
using namespace std;

int reverse_num(int num){
    int reversed = 0;
    while(num > 0){
        reversed = reversed * 10 + (num % 10);
        num /= 10;
    }
    return reversed;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N, K;
    cin >> N >> K;
    
    int max_reversed = 0;
    
    for(int i = 1; i <= K; ++i){
        int product = N * i;
        int reversed = reverse_num(product);
        if(reversed > max_reversed){
            max_reversed = reversed;
        }
    }
    
    cout << max_reversed;
    
    return 0;
}