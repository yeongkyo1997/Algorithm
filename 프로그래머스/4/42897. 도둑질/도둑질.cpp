#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int rob_linear(const vector<int>& money, int start, int end) {
    int prev1 = 0;
    int prev2 = 0; 
    for(int i = start; i < end; ++i){
        int current = max(prev1, prev2 + money[i]);
        prev2 = prev1;
        prev1 = current;
    }
    return prev1;
}

int solution(vector<int> money) {
    int n = money.size();
    
    if(n == 1){
        return money[0];
    }
    if(n == 2){
        return max(money[0], money[1]);
    }
    
    int case1 = rob_linear(money, 0, n-1);
    
    int case2 = rob_linear(money, 1, n);
    
    return max(case1, case2);
}