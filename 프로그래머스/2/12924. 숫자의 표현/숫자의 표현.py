from itertools import combinations

def solution(n):
    result = 0
    c_sum = 0
    right = 0
    
    if n == 1:
        return 1
    
    for l in range(1, n + 1):
        while c_sum < n and l < n:
            c_sum += right
            right += 1
        
        if c_sum == n:
            result += 1
        c_sum -= l
        
    return result
            