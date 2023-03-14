import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
dp = [[-1] * (1 << n) for _ in range(n)]


def tsp(cur, visited):
    if visited == (1 << n) - 1:
        if arr[cur][0] != 0:
            return arr[cur][0]
        return 1e9

    if dp[cur][visited] != -1:
        return dp[cur][visited]

    dp[cur][visited] = 1e9
    for i in range(n):
        if arr[cur][i] != 0 and visited & (1 << i) == 0:
            dp[cur][visited] = min(dp[cur][visited], tsp(i, visited | (1 << i)) + arr[cur][i])
    return dp[cur][visited]


print(tsp(0, 1))
