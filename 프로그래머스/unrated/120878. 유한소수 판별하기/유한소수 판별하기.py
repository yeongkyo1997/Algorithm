def solution(a, b):
    def gcd(a, b):
        if b == 0:
            return a
        return gcd(b, a % b)
    
    a, b = a // gcd(a, b), b // gcd(a, b)
    
    while b % 2 == 0:
        b /= 2
        
    while b % 5 == 0:
        b /= 5
        
    return min(2, b)

    