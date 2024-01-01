def solution(num, k):
    result = str(num).find(str(k)) + 1
    return -1 if result == 0 else result