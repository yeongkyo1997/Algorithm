import collections
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(M)]
visited = [[0] * N for _ in range(M)]
queue = collections.deque()
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]


def check():
    for i in range(M):
        for j in range(N):
            if arr[i][j] == 0:
                return False

    return True


def bfs():
    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]

            if 0 <= nx < M and 0 <= ny < N and visited[nx][ny] == 0 and arr[nx][ny] == 0:
                visited[nx][ny] = visited[x][y] + 1
                arr[nx][ny] = 1
                queue.append((nx, ny))

    if check():
        return max(map(max, visited))
    else:
        return -1


for i in range(M):
    for j in range(N):
        if arr[i][j] == 1:
            queue.append((i, j))

print(bfs())