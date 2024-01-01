def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)


def lcm(a, b):
    return (a * b) // gcd(a, b)

def solution(n):
    l = lcm(n, 6)
    
    return l // 6

    