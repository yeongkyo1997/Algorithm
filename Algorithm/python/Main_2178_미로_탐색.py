import collections
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())
arr = [list(map(int, list(input()))) for _ in range(N)]

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

q = collections.deque()
q.append((0, 0, 1))

while q:
    x, y, depth = q.popleft()

    if x == N - 1 and y == M - 1:
        print(depth)
        exit(0)

    for i in range(4):
        nx, ny, ndepth = x + dx[i], y + dy[i], depth + 1

        if 0 <= nx < N and 0 <= ny < M and arr[nx][ny] == 1:
            arr[nx][ny] = 0
            q.append((nx, ny, ndepth))
