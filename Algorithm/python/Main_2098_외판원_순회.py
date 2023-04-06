import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N = int(input())
arr = [[0] * N for i in range(N)]
for i in range(N):
    arr[i] = list(map(int, input().split()))
dp = [[0] * (1 << N) for i in range(N)]


def dfs(cur, visit):
    if visit == (1 << N) - 1:
        if arr[cur][0] == 0:
            return 987654321
        return arr[cur][0]
    if dp[cur][visit] != 0:
        return dp[cur][visit]
    dp[cur][visit] = 987654321
    for i in range(N):
        if arr[cur][i] == 0:
            continue
        if visit & (1 << i) == (1 << i):
            continue
        dp[cur][visit] = min(dp[cur][visit], arr[cur][i] + dfs(i, visit | (1 << i)))
    return dp[cur][visit]


print(dfs(0, 1))
