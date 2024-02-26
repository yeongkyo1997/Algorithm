from collections import defaultdict

def solution(n, tops):
    result = 0
    dp = {i : [0] * 4 for i in range(n)}
    
    dp[0] = [1] * 4
    
    if not tops[0]:
        dp[0][3] = 0
        
    for i in range(1, n):
        dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % 10007
        dp[i][1] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][3]) % 10007
        dp[i][2] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % 10007
        if tops[i]:
            dp[i][3] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % 10007
    return sum(dp[n - 1]) % 10007