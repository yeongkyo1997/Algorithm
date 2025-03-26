import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())

board = [list(map(int, input())) for _ in range(N)]

q = deque([(0, 0, 1)])
visited = set([(0, 0)])

result = -1
while q:
    x, y, dist = q.popleft()

    if x == N - 1 and y == M - 1:
        result = dist
        break

    for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
        nx, ny = x + dx, y + dy

        if (
            0 <= nx < N
            and 0 <= ny < M
            and (nx, ny) not in visited
            and board[nx][ny] == 1
        ):
            visited.add((nx, ny))
            q.append((nx, ny, dist + 1))


print(result)
