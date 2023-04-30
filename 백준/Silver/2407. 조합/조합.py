import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def comb(n, m):
    if n == m or m == 0:
        return 1
    if dp[n][m] != 0:
        return dp[n][m]
    dp[n][m] = comb(n - 1, m - 1) + comb(n - 1, m)
    return dp[n][m]


n, m = map(int, input().split())
dp = [[0] * (n + 1) for _ in range(n + 1)]

print(comb(n, m))
