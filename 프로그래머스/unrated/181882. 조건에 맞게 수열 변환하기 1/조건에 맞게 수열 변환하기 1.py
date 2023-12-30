def solution(arr):
    return list(map(lambda x:change(x), arr))

def change(n):
    if n >= 50 and n % 2 == 0:
        return n // 2
    if n < 50 and n % 2 != 0:
        return n * 2
    return n