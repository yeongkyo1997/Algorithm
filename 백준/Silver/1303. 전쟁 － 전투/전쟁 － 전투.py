import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())
arr = [list(input().strip()) for _ in range(m)]
visited = [[False] * n for _ in range(m)]

w = 0
b = 0


def bfs(x, y):
    queue = deque()
    res = 1
    queue.append((x, y, arr[x][y]))
    visited[x][y] = True

    while queue:
        dx = [0, 0, -1, 1]
        dy = [-1, 1, 0, 0]
        x, y, color = queue.popleft()

        for i in range(4):
            nx, ny, = x + dx[i], y + dy[i]
            if 0 <= nx < m and 0 <= ny < n and not visited[nx][ny] and arr[nx][ny] == color:
                visited[nx][ny] = True
                res += 1
                queue.append((nx, ny, color))
    return res


for i in range(m):
    for j in range(n):
        if not visited[i][j]:
            tmp = bfs(i, j)
            if arr[i][j] == "W":
                w += tmp ** 2
            else:
                b += tmp ** 2

print(w, b)
