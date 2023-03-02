import collections
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N = int(input())

arr = [list(input()) for _ in range(N)]
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]


def bfs(x, y, color):
    queue = collections.deque()
    queue.append((x, y))
    visited[x][y] = True

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]

            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] and arr[nx][ny] == color:
                visited[nx][ny] = True
                queue.append((nx, ny))


cnt = 0
visited = [[False] * N for _ in range(N)]

for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            bfs(i, j, arr[i][j])
            cnt += 1
print(cnt, end=' ')
for i in range(N):
    for j in range(N):
        if arr[i][j] == 'R':
            arr[i][j] = 'G'

visited = [[False] * N for _ in range(N)]

cnt = 0
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            bfs(i, j, arr[i][j])
            cnt += 1
print(cnt)