from collections import deque

def solution(n):
    result = 0
    while n:
        if n % 2 == 0:
            n //= 2
        else:
            result += 1
            n -= 1
    return result