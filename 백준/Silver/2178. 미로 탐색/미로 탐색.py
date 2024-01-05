import sys
from collections import deque, defaultdict


def input(): return sys.stdin.readline().strip()


n, m = map(int, input().split())
arr = [list(map(int, input())) for _ in range(n)]
visited = defaultdict(lambda: [False] * m)

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

q = deque()
q.append((0, 0, 1))

while q:
    x, y, depth = q.popleft()
    if x == n - 1 and y == m - 1:
        print(depth)
        break

    for i in range(4):
        nx, ny, ndepth = x + dx[i], y + dy[i], depth + 1

        if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and arr[nx][ny] == 1:
            q.append((nx, ny, ndepth))
            visited[nx][ny] = True