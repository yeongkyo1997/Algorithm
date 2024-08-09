import collections

X = int(input())

dp = collections.defaultdict()

dp[1] = 0
dp[2] = 1
dp[3] = 1

for i in range(4, X + 1):
    dp[i] = dp[i - 1] + 1
    if i % 2 == 0:
        dp[i] = min(dp[i // 2] + 1, dp[i])
    if i % 3 == 0:
        dp[i] = min(dp[i // 3] + 1, dp[i])

print(dp[X])