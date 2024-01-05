import sys
from functools import cache

sys.setrecursionlimit(10 ** 5)
def input(): return sys.stdin.readline().strip()


@cache
def solve(n):
    if n == 0:
        return 1
    if n < 0:
        return 0
    return solve(n - 1) + solve(n - 2) + solve(n - 3)


T = int(input())
for i in range(T):
    n = int(input())
    print(solve(n))