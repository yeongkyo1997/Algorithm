def solution(a, b):
    return max(map(int, [str(a) + str(b), str(b) + str(a)]))