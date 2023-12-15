import sys
from collections import deque, defaultdict


def input(): return sys.stdin.readline().rstrip()


dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]


def bfs(x, y, height):
    global N
    q = deque([(x, y)])
    visited[x][y] = True

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]

            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] and arr[nx][ny] > height:
                visited[nx][ny] = True
                q.append((nx, ny))


result = 0
for k in range(0, 101):
    area = 0
    visited = [[False] * N for _ in range(N)]
    for i in range(0, N):
        for j in range(0, N):
            if arr[i][j] > k and not visited[i][j]:
                bfs(i, j, k)
                area += 1
    result = max(result, area)

print(result)