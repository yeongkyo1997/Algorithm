def solution(n):
    return sum(1 for i in range(1, n + 1) if is_cnt(i))
    

def is_cnt(n):
    result = 0
    
    for i in range(1, n + 1):
        if n % i == 0:
            result += 1
    
    return True if result >= 3 else False