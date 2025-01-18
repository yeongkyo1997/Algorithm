def solution(strs, t):
    
    words_set = set(strs)
    
    
    min_len = min(len(word) for word in strs)
    max_len = max(len(word) for word in strs)
    
    
    n = len(t)
    dp = [float('inf')] * (n + 1)
    dp[0] = 0  
    
    
    for i in range(1, n + 1):
        
        for l in range(min_len, max_len + 1):
            if i - l < 0:
                continue  
            substring = t[i - l:i]
            if substring in words_set:
                if dp[i - l] + 1 < dp[i]:
                    dp[i] = dp[i - l] + 1
    
    
    return dp[n] if dp[n] != float('inf') else -1