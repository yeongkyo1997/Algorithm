def solution(n):
    if n % 2 != 0:
        return sum(range(1, n + 1, 2))
    else:
        return sum(map(lambda x : x ** 2, range(2, n + 1, 2)))
            