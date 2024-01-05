import sys
from functools import cache


sys.setrecursionlimit(10 ** 5)


def input(): return sys.stdin.readline().strip()


n = int(input())


@cache
def solve(n):
    if n == 1:
        return 0
    if n % 2 == n % 3 == 0:
        return min(solve(n // 2), solve(n // 3)) + 1
    elif n % 3 == 0:
        return min(solve(n - 1), solve(n // 3)) + 1
    elif n % 2 == 0:
        return min(solve(n - 1), solve(n // 2)) + 1
    else:
        return solve(n - 1) + 1


print(solve(n))