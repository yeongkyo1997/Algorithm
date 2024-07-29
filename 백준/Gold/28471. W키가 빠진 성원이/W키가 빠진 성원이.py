import collections

dir = [(-1, -1), (-1, 1), (0, 1), (1, 1), (-1, 0), (1, -1), (0, -1)]

N = int(input())
board = [list(input()) for _ in range(N)]


def bfs(x, y):
    q = collections.deque([(x, y)])
    visited = [[False] * N for _ in range(N)]

    while q:
        x, y = q.popleft()

        for dx, dy in dir:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < N and board[nx][ny] == '.' and not visited[nx][ny]:
                visited[nx][ny] = True
                q.append((nx, ny))

    return visited


fx, fy = -1, -1
for i in range(N):
    for j in range(N):
        if board[i][j] == 'F':
            fx, fy = i, j

visited = bfs(fx, fy)

result = 0

for i in range(N):
    for j in range(N):
        if visited[i][j] and board[i][j] == '.':
            result += 1

print(result)