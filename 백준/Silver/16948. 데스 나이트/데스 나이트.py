import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
r1, c1, r2, c2 = map(int, input().split())
visited = [[False] * N for _ in range(N)]

dir = [[-2, -1], [-2, 1], [0, -2], [0, 2], [2, -1], [2, 1]]

queue = deque()
queue.append((r1, c1, 0))
visited[r1][c1] = True

if r1 == r2 and c1 == c2:
    print(0)
    exit()

while queue:
    x, y, depth = queue.popleft()

    for dx, dy in dir:
        nx, ny, ndepth = x + dx, y + dy, depth + 1

        if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny]:
            if nx == r2 and ny == c2:
                print(ndepth)
                exit()
            visited[nx][ny] = True
            queue.append((nx, ny, ndepth))

print(-1)
