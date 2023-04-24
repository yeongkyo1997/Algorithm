def solution(n):
    if n % 2 == 0:
        return sum(x ** 2 for x in range(1, n + 1) if x % 2 == 0)
    else:
        return sum(x for x in range(1, n + 1) if x % 2 != 0)