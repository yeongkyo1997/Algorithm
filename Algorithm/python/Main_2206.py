import collections
import sys

input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())

arr = [list(map(int, list(input()))) for _ in range(N)]
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

visited = [[[0] * 2 for _ in range(M)] for _ in range(N)]


def bfs():
    queue = collections.deque()
    queue.append((0, 0, 1))
    visited[0][0][1] = 1

    while queue:
        x, y, z = queue.popleft()

        if x == N - 1 and y == M - 1:
            return visited[x][y][z]

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]

            if 0 <= nx < N and 0 <= ny < M:
                if arr[nx][ny] == 0 and visited[nx][ny][z] == 0:
                    visited[nx][ny][z] = visited[x][y][z] + 1
                    queue.append((nx, ny, z))
                elif arr[nx][ny] == 1 and z == 1:
                    visited[nx][ny][z - 1] = visited[x][y][z] + 1
                    queue.append((nx, ny, z - 1))

    return -1


print(bfs())
