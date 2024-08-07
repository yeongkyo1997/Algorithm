import collections

n = int(input())

MOD = 10_007

dp = collections.defaultdict()

dp[1] = 1
dp[2] = 2

for i in range(3, n + 1):
    dp[i] = dp[i - 1] % MOD + dp[i - 2] % MOD

print(dp[n] % MOD)