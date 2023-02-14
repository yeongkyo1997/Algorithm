import math

def solution(a, b):
    b = b / math.gcd(a, b)

    while b != 1:
        if b % 5 == 0:
            b /= 5
        elif b % 2 == 0:
            b /= 2
        else:
            return 2
    return 1
