import collections
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N = int(input())

arr = [list(input()) for _ in range(N)]

dir = [[1, 0], [-1, 0], [0, 1], [0, -1]]


def bfs(x, y, color):
    q = collections.deque()
    q.append((x, y))
    visited[x][y] = True

    while q:
        x, y = q.popleft()

        for dx, dy in dir:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] and color == arr[nx][ny]:
                visited[nx][ny] = True
                q.append((nx, ny))


visited = [[False] * N for _ in range(N)]
cnt = 0
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            cnt += 1
            bfs(i, j, arr[i][j])

print(cnt)
for i in range(N):
    for j in range(N):
        if arr[i][j] == 'G':
            arr[i][j] = 'R'

visited = [[False] * N for _ in range(N)]
cnt = 0
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            cnt += 1
            bfs(i, j, arr[i][j])

print(cnt)
