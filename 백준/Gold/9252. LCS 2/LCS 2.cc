#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    string s1, s2;
    cin >> s1 >> s2;
    
    int n = s1.size(), m = s2.size();
    vector<vector<int>> dp(n+1, vector<int>(m+1, 0));
    
    for (int i = 1; i <= n; i++){
        for (int j = 1; j <= m; j++){
            if (s1[i-1] == s2[j-1])
                dp[i][j] = dp[i-1][j-1] + 1;
            else
                dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
        }
    }
    
    int lcsLength = dp[n][m];
    cout << lcsLength << "\n";
    
    if(lcsLength == 0)
        return 0;
    
    string lcs;
    int i = n, j = m;
    while(i > 0 && j > 0){
        if(s1[i-1] == s2[j-1]){
            lcs.push_back(s1[i-1]);
            i--;
            j--;
        } else {
            if(dp[i-1][j] >= dp[i][j-1])
                i--;
            else
                j--;
        }
    }
    
    reverse(lcs.begin(), lcs.end());
    cout << lcs;
    
    return 0;
}
