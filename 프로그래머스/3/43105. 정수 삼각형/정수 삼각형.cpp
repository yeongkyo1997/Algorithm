#include <string>
#include <vector>
#include <algorithm> 

using namespace std;

int solution(vector<vector<int>> triangle) {
    int n = triangle.size();
    
    vector<vector<int>> dp = triangle;
    
    for(int i = 1; i < n; i++) { 
        for(int j = 0; j <= i; j++) {
            if(j == 0) {
                dp[i][j] += dp[i-1][j];
            }
            else if(j == i) {
                dp[i][j] += dp[i-1][j-1];
            }
            else {
                dp[i][j] += max(dp[i-1][j-1], dp[i-1][j]);
            }
        }
    }
    
    return *max_element(dp[n-1].begin(), dp[n-1].end());
}