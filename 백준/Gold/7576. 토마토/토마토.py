import sys
from collections import deque


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(M)]

q = deque()

for i in range(M):
    for j in range(N):
        if board[i][j] == 1:
            q.append((i, j))

d = [(-1, 0), (1, 0), (0, -1), (0, 1)]

while q:
    x, y = q.popleft()

    for dx, dy in d:
        nx, ny = x + dx, y + dy

        if 0 <= nx < M and 0 <= ny < N and board[nx][ny] == 0:
            board[nx][ny] = board[x][y] + 1
            q.append((nx, ny))

for i in range(M):
    for j in range(N):
        if board[i][j] == 0:
            print(-1)
            exit(0)

print(max(max(i) for i in board) - 1)