import math

N = int(input())
dp = [math.inf] * (N + 1)
dp[1] = 0 

for i in range(2, N + 1):
    if i % 3 == 0:
        dp[i] = min(dp[i], dp[i // 3] + 1)
    if i % 2 == 0:
        dp[i] = min(dp[i], dp[i // 2] + 1)
    dp[i] = min(dp[i], dp[i - 1] + 1)

print(dp[N])
