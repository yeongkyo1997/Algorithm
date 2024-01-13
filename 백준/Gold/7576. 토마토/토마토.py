import sys
from collections import deque


def input(): return sys.stdin.readline().rstrip()


M, N = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]


d = [(-1, 0), (1, 0), (0, -1), (0, 1)]

q = deque()

for i in range(N):
    for j in range(M):
        if board[i][j] == 1:
            q.append((i, j))


def bfs():
    global q

    while q:
        x, y = q.popleft()

        for dx, dy in d:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == 0:
                board[nx][ny] = board[x][y] + 1
                q.append((nx, ny))
    if check():
        print(max(max(i for i in board[j]) for j in range(N)) - 1)
    else:
        print(-1)


def check():
    for i in range(N):
        for j in range(M):
            if board[i][j] == 0:
                return False
    return True


bfs()