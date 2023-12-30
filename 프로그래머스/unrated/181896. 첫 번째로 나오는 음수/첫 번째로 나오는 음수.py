def solution(num_list):
    for i, ele in enumerate(num_list):
        if ele < 0:
            return i
    return -1