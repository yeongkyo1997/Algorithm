import collections
import sys

input = lambda: sys.stdin.readline().rstrip()

X = int(input())

result = 0
dp = collections.defaultdict(int)

for i in range(1, X + 1):
    if i == 1:
        dp[i] = 0
        continue
    dp[i] = dp[i - 1] + 1
    if i % 2 == 0:
        dp[i] = min(dp[i], dp[i // 2] + 1)
    if i % 3 == 0:
        dp[i] = min(dp[i], dp[i // 3] + 1)

print(dp[X])
