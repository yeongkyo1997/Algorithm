import sys
from collections import deque


def input(): return sys.stdin.readline().rstrip()


d = [(-1, 0), (1, 0), (0, -1), (0, 1), (-1, -1), (-1, 1), (1, -1), (1, 1)]


def bfs(x, y):
    global w, h
    q = deque([(x, y)])
    board[x][y] = 0

    while q:
        x, y = q.popleft()
        for dx, dy in d:
            nx, ny = x + dx, y + dy

            if 0 <= nx < h and 0 <= ny < w and board[nx][ny] != 0:
                board[nx][ny] = 0
                q.append((nx, ny))


while True:
    w, h = map(int, input().split())
    if w == h == 0:
        break
    board = [list(map(int, input().split())) for _ in range(h)]
    result = 0

    for i in range(h):
        for j in range(w):
            if board[i][j] == 1:
                result += 1
                bfs(i, j)

    print(result)