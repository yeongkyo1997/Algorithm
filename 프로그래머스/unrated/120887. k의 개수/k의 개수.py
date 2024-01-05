def solution(i, j, k):
    result = 0
    for n in range(i, j + 1):
        result += str(n).count(str(k))
    return result