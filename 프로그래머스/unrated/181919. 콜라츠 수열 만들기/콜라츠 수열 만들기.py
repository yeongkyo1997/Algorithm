def solution(n):
    result = []
    
    while n != 1:
        result.append(n)
        
        if n % 2 == 0:
            n //= 2
        else:
            n = 3 * n + 1
            
    result.append(1)
    return result