def solution(n, t, m, p):
    result = ''
    
    for i in range((t * m)+ 1):
        result += change(i, n)
    
    return result[p - 1::m][:t]
    
        
        
        
    
def change(n, k):
    alpha = '0123456789ABCDEF'
    result = ''
    if n == 0:
        return '0'
    
    while n:
        result = alpha[n % k] + result
        n //= k
    
    return result
