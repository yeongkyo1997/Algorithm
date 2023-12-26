def solution(a, b, n):
    result = 0
    
    while n >= a:
        tmp = n // a * b
        result += tmp
        
        n = n % a + tmp
        
    return result