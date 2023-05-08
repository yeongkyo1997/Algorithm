import sys

input = lambda: sys.stdin.readline().rstrip()

n = int(input())

dp = [[-1001] * (n + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    arr = list(map(int, input().split()))

    for j in range(1, n + 1):
        dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + arr[j - 1]

MAX = dp[0][0]

for k in range(n):
    for i in range(1, n - k + 1):
        for j in range(1, n - k + 1):
            MAX = max(MAX, dp[i + k][j + k] - dp[i - 1][j + k] - dp[i + k][j - 1] + dp[i - 1][j - 1])

print(MAX)