import sys
from collections import deque


def input(): return sys.stdin.readline().rstrip()


dx = [0, 0, 0, 0, -1, 1]
dy = [0, 0, -1, 1, 0, 0]
dz = [-1, 1, 0, 0, 0, 0]

M, N, H = map(int, input().split())
board = []
for i in range(H):
    tmp = []
    for j in range(N):
        tmp.append(list(map(int, input().split())))
    board.append(tmp)

q = deque()
visited = [[[0] * M for _ in range(N)] for _ in range(H)]
for i in range(H):
    for j in range(N):
        for k in range(M):
            if board[i][j][k] == 1:
                q.append((i, j, k))

while q:
    z, x, y = q.popleft()

    for i in range(len(dx)):
        nz, nx, ny = z + dz[i], x + dx[i], y + dy[i]
        if 0 <= nz < H and 0 <= nx < N and 0 <= ny < M and not visited[nz][nx][ny] and board[nz][nx][ny] == 0:
            board[nz][nx][ny] = 1
            visited[nz][nx][ny] = visited[z][x][y] + 1
            q.append((nz, nx, ny))

result = 0
for i in range(H):
    for j in range(N):
        for k in range(M):
            if board[i][j][k] == 0:
                print(-1)
                exit(0)
            else:
                result = max(result, visited[i][j][k])

print(result)