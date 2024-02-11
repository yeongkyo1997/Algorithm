import sys
from functools import cache

sys.setrecursionlimit(10 ** 5)


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]

d = [(0, -1), (0, 1), (-1, 0), (1, 0)]


@cache
def dfs(x, y):
    if x == N - 1 and y == M - 1:
        return 1

    result = 0

    for dx, dy in d:
        nx, ny = x + dx, y + dy
        if 0 <= nx < N and 0 <= ny < M and board[x][y] > board[nx][ny]:
            result += dfs(nx, ny)

    return result


print(dfs(0, 0))