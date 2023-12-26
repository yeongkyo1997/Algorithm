from functools import reduce
import math

def solution(arr):
    def lcm(x, y):
        return x * y // math.gcd(x, y)
    
    return reduce(lcm, arr)