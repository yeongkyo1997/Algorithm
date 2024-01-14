import sys
from functools import cache
from collections import defaultdict

sys.setrecursionlimit(10 ** 5)


def input(): return sys.stdin.readline().rstrip()


N = int(input())
dp = defaultdict(int)

MOD = 15746


dp[0] = 0
dp[1] = 1
dp[2] = 2

for i in range(3, N + 1):
    dp[i] = (dp[i - 1] + dp[i - 2]) % MOD


print(dp[N])