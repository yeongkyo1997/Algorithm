import sys
import math
from functools import cache

sys.setrecursionlimit(10 ** 5)


def input(): return sys.stdin.readline().rstrip()


MOD = 1000000007

n, k = map(int, input().split())


def factorial(num):
    n = 1
    for i in range(2, num + 1):
        n = (n * i) % MOD
    return n


@cache
def square(n, k):
    if k == 0:
        return 1
    elif k == 1:
        return n
    tmp = square(n, k // 2)

    return tmp ** 2 * n % MOD if k % 2 else tmp ** 2 % MOD


top = factorial(n)
bot = factorial(n - k) * factorial(k) % MOD

print(top * square(bot, MOD - 2) % MOD)