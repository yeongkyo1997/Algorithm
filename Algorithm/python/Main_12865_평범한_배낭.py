import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N, K = map(int, input().split())
dp = [[0] * (K + 1) for _ in range(N + 1)]
W = [0] * (N + 1)
V = [0] * (N + 1)
for i in range(1, N + 1):
    W[i], V[i] = map(int, input().split())
for i in range(1, N + 1):
    for j in range(1, K + 1):
        if W[i] > j:
            dp[i][j] = dp[i - 1][j]
        else:
            dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i])
print(dp[N][K])
