import collections

N = int(input())

arr = [0]

for _ in range(N):
    arr.append(int(input()))

dp = collections.defaultdict(int)

dp[0] = 0
if N >= 1:
    dp[1] = arr[1]
if N >= 2:
    dp[2] = dp[1] + arr[2]
if N >= 3:
    dp[3] = max(arr[1], arr[2]) + arr[3]

for i in range(4, N + 1):
    dp[i] = max(dp[i - 2], dp[i - 1 - 2] + arr[i - 1]) + arr[i]

print(dp[N])