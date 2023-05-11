def solution(arr):
    n = len(arr)
    m = 1
    while m < n:
        m *= 2
    return arr + [0] * (m - n)
