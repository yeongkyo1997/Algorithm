def solution(n):
    dp = {
        0 : 0,
        1 : 1,
        2 : 1
    }
    
    if n <= 2:
        return dp[n]
    
    for i in range(3, n + 1):
        dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567
        
    return dp[n]
    