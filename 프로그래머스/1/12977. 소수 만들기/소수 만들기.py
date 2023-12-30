import math
from itertools import combinations

def solution(nums):
    combi = list(sum(i) for i in combinations(nums, 3))
    
    return sum(1 for i in combi if is_prime(i))
    
    
def is_prime(n):
    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            return False
    return True
    