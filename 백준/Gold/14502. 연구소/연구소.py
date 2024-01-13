import sys
from collections import deque
import copy

sys.setrecursionlimit(10 ** 5)


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]

virus = []
for i in range(N):
    for j in range(M):
        if board[i][j] == 2:
            virus.append((i, j))


def cnt_safearea(board):
    ret = 0

    for i in board:
        ret += i.count(0)

    return ret


d = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def bfs(board):
    q = deque(virus)

    while q:
        x, y = q.popleft()

        for dx, dy in d:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == 0:
                board[nx][ny] = 2
                q.append((nx, ny))

    return cnt_safearea(board)


def dfs(n, x, y):
    global result
    if n == 0:
        copy_board = copy.deepcopy(board)
        result = max(result, bfs(copy_board))
        return

    for i in range(x, N):
        for j in range(y if x == i else 0, M):
            if board[i][j] == 0:
                board[i][j] = 1
                dfs(n - 1, i, j)
                board[i][j] = 0


result = 0
dfs(3, 0, 0)
print(result)