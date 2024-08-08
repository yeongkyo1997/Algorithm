import collections

dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]

N = int(input())

board = [list(input()) for _ in range(N)]

rgb = {
    'R': 0,
    'G': 0,
    'B': 0
}


def bfs(x, y, color):
    q = collections.deque()
    q.append((x, y))
    visited[x][y] = True

    while q:
        x, y = q.popleft()

        for dx, dy in dir:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < N and board[nx][ny] == color and not visited[nx][ny]:
                visited[nx][ny] = True
                q.append((nx, ny))
    return 1


visited = [[False] * N for _ in range(N)]
result = 0
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            result += bfs(i, j, board[i][j])
print(result, end=' ')

for i in range(N):
    for j in range(N):
        if board[i][j] == 'R':
            board[i][j] = 'G'
            
result = 0

visited = [[False] * N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            result += bfs(i, j, board[i][j])

print(result)