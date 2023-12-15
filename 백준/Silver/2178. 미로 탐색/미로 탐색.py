import sys
from collections import defaultdict, deque


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

arr = []
for _ in range(N):
    arr.append(list(map(int, list(input()))))


def bfs():
    q = deque()
    q.append((0, 0, 1))

    while q:
        x, y, depth = q.popleft()

        if x == N - 1 and y == M - 1:
            print(depth)
            exit(0)

        for i in range(4):
            nx, ny, ndepth = x + dx[i], y + dy[i], depth + 1

            if 0 <= nx < N and 0 <= ny < M and arr[nx][ny] == 1:
                q.append((nx, ny, ndepth))
                arr[nx][ny] = 0


bfs()