import sys
from collections import deque


def input(): return sys.stdin.readline().rstrip()


n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
visited = [[-1] * m for _ in range(n)]

q = deque()
for i in range(n):
    for j in range(m):
        if board[i][j] == 2:
            q.append((i, j))
            visited[i][j] = 0
            break


d = [(-1, 0), (1, 0), (0, -1), (0, 1)]
while q:
    x, y = q.popleft()

    for dx, dy in d:
        nx, ny = x + dx, y + dy

        if 0 <= nx < n and 0 <= ny < m and visited[nx][ny] == -1 and board[nx][ny] != 0:
            visited[nx][ny] = visited[x][y] + 1
            q.append((nx, ny))


for i in range(n):
    for j in range(m):
        if board[i][j] == 0:
            visited[i][j] = 0

for i in visited:
    print(*i)