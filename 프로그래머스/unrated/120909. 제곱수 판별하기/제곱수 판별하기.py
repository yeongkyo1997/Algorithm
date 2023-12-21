import math
def solution(n):
    if n ** 0.5 == math.ceil(n ** 0.5):
        return 1
    else:
        return 2