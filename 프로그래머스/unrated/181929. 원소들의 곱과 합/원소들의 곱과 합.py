from functools import reduce
def solution(num_list):
    s = sum(num_list) ** 2
    m = reduce(lambda x, y : x * y, num_list)
    
    if s > m:
        return 1
    else:
        return 0