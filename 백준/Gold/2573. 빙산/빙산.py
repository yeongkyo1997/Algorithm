from copy import deepcopy
import sys
from collections import deque


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]

d = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def melt(cp_board):
    for i in range(N):
        for j in range(M):
            if cp_board[i][j] != 0:
                for dx, dy in d:
                    nx, ny = i + dx, j + dy
                    if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == 0 and cp_board[i][j] > 0:
                        cp_board[i][j] -= 1


def check_sep(cp_board, x, y):
    q = deque([(x, y)])
    visited[x][y] = True

    while q:
        x, y = q.popleft()

        for dx, dy in d:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < M and cp_board[nx][ny] != 0 and not visited[nx][ny]:
                visited[nx][ny] = True
                q.append((nx, ny))


result = 0
while True:
    visited = [[False] * M for _ in range(N)]
    cp_board = deepcopy(board)
    melt(cp_board)
    result += 1
    tmp = 0
    for i in range(N):
        for j in range(M):
            if cp_board[i][j] != 0 and not visited[i][j]:
                tmp += 1
                check_sep(cp_board, i, j)
    board = deepcopy(cp_board)
    if tmp == 0:
        print(0)
        break
    elif tmp == 1:
        continue
    else:
        print(result)
        break