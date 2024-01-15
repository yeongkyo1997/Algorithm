import sys
from collections import deque


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())

board = [input() for _ in range(N)]


visited = [[[0] * (1 << 6 + 1) for _ in range(M)] for _ in range(N)]

d = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def bfs(x, y, keys):
    q = deque([(x, y, keys)])
    visited[x][y][keys] = 1

    while q:
        x, y, keys = q.popleft()
        if board[x][y] == '1':
            return visited[x][y][keys] - 1
        for dx, dy in d:
            nx, ny = x + dx, y + dy

            if nx < 0 or nx >= N or ny < 0 or ny >= M or board[nx][ny] == '#' or visited[nx][ny][keys] != 0:
                continue

            if ord('A') <= ord(board[nx][ny]) <= ord('F') and keys & (1 << (ord(board[nx][ny]) - ord('A'))) == 0:
                continue

            if ord('A') <= ord(board[nx][ny]) <= ord('F') and keys & (1 << (ord(board[nx][ny]) - ord('A'))) != 0:
                visited[nx][ny][keys] = visited[x][y][keys] + 1
                q.append((nx, ny, keys))
            if ord('a') <= ord(board[nx][ny]) <= ord('f'):
                k = keys | 1 << (ord(board[nx][ny]) - ord('a'))
                visited[nx][ny][k] = visited[x][y][keys] + 1
                q.append((nx, ny, k))
            if board[nx][ny] != '#':
                visited[nx][ny][keys] = visited[x][y][keys] + 1
                q.append((nx, ny, keys))
    return -1


for i in range(N):
    for j in range(M):
        if board[i][j] == '0':
            print(bfs(i, j, 0))
            break
    else:
        continue
    break