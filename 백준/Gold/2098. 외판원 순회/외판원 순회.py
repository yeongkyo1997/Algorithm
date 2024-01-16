from functools import cache
import sys


def input(): return sys.stdin.readline().rstrip()


INF = int(1e9)
N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]
dp = [[INF] * (1 << N) for _ in range(N)]


@cache
def dfs(cur, visited):
    if visited == (1 << N) - 1:
        if board[cur][0]:
            return board[cur][0]
        else:
            return INF

    if dp[cur][visited] != INF:
        return dp[cur][visited]

    for i in range(1, N):
        if visited & (1 << i):
            continue
        if not board[cur][i]:
            continue

        dp[cur][visited] = min(dp[cur][visited], dfs(
            i, visited | (1 << i)) + board[cur][i])
    return dp[cur][visited]


print(dfs(0, 1))