import collections
import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = collections.defaultdict(int)
for i in range(n):
    arr[i] = int(input())
dp = collections.defaultdict(int)
dp[0] = arr[0]
dp[1] = arr[0] + arr[1]
dp[2] = max(arr[0] + arr[1], arr[0] + arr[2], arr[1] + arr[2])

for i in range(3, n):
    dp[i] = max(dp[i - 1], dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i])

print(dp[n - 1])