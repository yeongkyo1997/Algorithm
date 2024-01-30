import sys
from functools import cache
sys.setrecursionlimit(10 ** 5)


def input(): return sys.stdin.readline().rstrip()


N = int(input())

dp = [float('inf')] * (N + 1)


result = float('inf')

dp[0] = 0

for i in range(1, N + 1):
    j = 1
    while j ** 2 <= i:
        dp[i] = min(dp[i], dp[i - j * j] + 1)
        j += 1


print(dp[N])