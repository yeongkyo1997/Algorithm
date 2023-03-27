import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = [[0] * n for i in range(n)]
for i in range(n):
    arr[i] = list(map(int, input().split()))
dp = [[0] * (1 << n) for i in range(n)]


def dfs(cur, visit):
    if visit == (1 << n) - 1:
        if arr[cur][0] == 0:
            return 987654321
        return arr[cur][0]
    if dp[cur][visit] != 0:
        return dp[cur][visit]
    dp[cur][visit] = 987654321
    for i in range(n):
        if arr[cur][i] == 0:
            continue
        if visit & (1 << i) == (1 << i):
            continue
        dp[cur][visit] = min(dp[cur][visit], arr[cur][i] + dfs(i, visit | (1 << i)))
    return dp[cur][visit]


print(dfs(0, 1))
