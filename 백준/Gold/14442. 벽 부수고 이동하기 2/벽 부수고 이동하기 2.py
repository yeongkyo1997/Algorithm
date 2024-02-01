from collections import deque
import sys


def input(): return sys.stdin.readline().rstrip()


N, M, K = map(int, input().split())

visited = [[[float('inf')] * (K + 1) for _ in range(M)]for _ in range(N)]
visited[0][0][0] = 1
board = [list(map(int, input())) for _ in range(N)]

d = [(-1, 0), (1, 0), (0, -1), (0, 1)]
q = deque([(0, 0, 0)])

while q:
    x, y, wall = q.popleft()
    if x == N - 1 and y == M - 1:
        print(min(visited[x][y]))
        break

    for dx, dy in d:
        nx, ny = x + dx, y + dy

        if 0 <= nx < N and 0 <= ny < M:
            if board[nx][ny] == 0:
                if visited[nx][ny][wall] > visited[x][y][wall] + 1:
                    visited[nx][ny][wall] = visited[x][y][wall] + 1
                    q.append((nx, ny, wall))
            else:
                if wall < K and visited[nx][ny][wall + 1] > visited[x][y][wall] + 1:
                    visited[nx][ny][wall + 1] = visited[x][y][wall] + 1
                    q.append((nx, ny, wall + 1))
else:
    print(-1)