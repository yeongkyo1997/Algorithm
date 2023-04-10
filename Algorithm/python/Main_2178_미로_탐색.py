import collections
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())

arr = [list(map(int, list(input()))) for _ in range(N)]

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

visited = [[False] * M for _ in range(N)]


def bfs():
    q = collections.deque()
    q.append((0, 0, 1))
    visited[0][0] = True

    while q:
        x, y, depth = q.popleft()
        if x == N - 1 and y == M - 1:
            return depth

        for sx, sy in zip(dx, dy):
            nx, ny, ndepth = x + sx, y + sy, depth + 1

            if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny] and arr[nx][ny] == 1:
                visited[nx][ny] = True
                q.append((nx, ny, ndepth))


print(bfs())
