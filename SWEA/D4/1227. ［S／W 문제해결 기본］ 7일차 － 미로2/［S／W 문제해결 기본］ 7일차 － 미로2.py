import collections


def bfs(x, y):
    q = collections.deque()
    q.append((x, y))
    board[x][y] = 1

    while q:
        x, y = q.popleft()

        if (ex, ey) == (x, y):
            return 1

        for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < N and board[nx][ny] != 1:
                board[nx][ny] = 1
                q.append((nx, ny))

    return 0


for _ in range(10):
    t = int(input())
    N = 100
    board = [list(map(int, input())) for _ in range(N)]

    sx, sy = -1, -1
    ex, ey = -1, -1
    for i in range(N):
        for j in range(N):
            if board[i][j] == 2:
                sx, sy = i, j
            if board[i][j] == 3:
                ex, ey = i, j
    print(f'#{t} {bfs(sx, sy)}')
