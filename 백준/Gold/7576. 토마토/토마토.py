import collections
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

M, N = map(int, input().split())
tomato = [list(map(int, input().split())) for _ in range(N)]
visited = [[0] * M for _ in range(N)]
dx, dy = [0, 0, 1, -1], [1, -1, 0, 0]
q = collections.deque()
for i in range(N):
    for j in range(M):
        if tomato[i][j] == 1:
            q.append((i, j))
            visited[i][j] = 1

while q:
    x, y = q.popleft()
    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if 0 <= nx < N and 0 <= ny < M and tomato[nx][ny] == 0 and visited[nx][ny] == 0:
            tomato[nx][ny] = 1
            visited[nx][ny] = visited[x][y] + 1
            q.append((nx, ny))

flag = 0
for i in range(N):
    for j in range(M):
        if tomato[i][j] == 0:
            flag = 1
            break
    if flag:
        break

if flag:
    print(-1)
else:
    print(max(map(max, visited)) - 1)