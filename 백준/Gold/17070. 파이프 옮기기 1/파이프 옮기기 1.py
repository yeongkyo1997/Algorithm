import sys
from functools import cache
sys.setrecursionlimit(10 ** 5)


def input(): return sys.stdin.readline().rstrip()


N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]


'''
0 : 대각선
1 : 오른쪽
2 : 아래
'''


@cache
def dfs(x, y, direction):
    if 0 > x or 0 > y or x >= N or y >= N:
        return 0
    if direction == 0:
        if board[x][y] == 1 or board[x - 1][y] == 1 or board[x][y - 1]:
            return 0
    else:
        if board[x][y] == 1:
            return 0

    if x == y == N - 1:
        return 1

    ret = 0
    if direction == 0:
        # 대각선
        ret += dfs(x + 1, y + 1, 0)
        # 오른쪽
        ret += dfs(x, y + 1, 1)
        # 아래
        ret += dfs(x + 1, y, 2)
    elif direction == 1:
        # 대각선
        ret += dfs(x + 1, y + 1, 0)
        # 오른쪽
        ret += dfs(x, y + 1, 1)
    elif direction == 2:
        # 대각선
        ret += dfs(x + 1, y + 1, 0)
        # 아래
        ret += dfs(x + 1, y, 2)
    return ret


print(dfs(0, 1, 1))