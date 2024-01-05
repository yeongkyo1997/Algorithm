import sys
from functools import cache

sys.setrecursionlimit(10 ** 5)
def input(): return sys.stdin.readline().strip()


@cache
def solve(n):
    if n == 1:
        return 1
    if n == 2:
        return 2

    return (solve(n - 1) + solve(n - 2)) % 10007


print(solve(int(input())))