import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())

board = [list(map(int, input())) for _ in range(N)]

dxy = [(-1, 0), (1, 0), (0, -1), (0, 1)]

q = deque([(0, 0, 1, 0)])  # x, y, 이동 횟수, 벽 부순 여부
visited = set()
visited.add((0, 0, 0))

result = -1
while q:
    x, y, dist, broken = q.popleft()

    if x == N - 1 and y == M - 1:
        result = dist
        break

    for dx, dy in dxy:
        nx, ny = x + dx, y + dy

        if 0 <= nx < N and 0 <= ny < M:
            if board[nx][ny] == 0 and (nx, ny, broken) not in visited:
                visited.add((nx, ny, broken))
                q.append((nx, ny, dist + 1, broken))
            elif board[nx][ny] == 1 and broken == 0 and (nx, ny, 1) not in visited:
                visited.add((nx, ny, 1))
                q.append((nx, ny, dist + 1, 1))


print(result)
