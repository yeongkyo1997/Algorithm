from functools import reduce

def solution(num_list):
    if (sum(num_list) ** 2) > reduce(lambda x, y : x * y, num_list):
        return 1
    else:
        return 0
        
    