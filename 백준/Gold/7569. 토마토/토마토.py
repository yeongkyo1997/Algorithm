import collections

dir = [(0, 0, -1), (0, 0, 1), (-1, 0, 0), (1, 0, 0), (0, -1, 0), (0, 1, 0)]

M, N, H = map(int, input().split())

board = [[list(map(int, input().split())) for _ in range(N)] for _ in range(H)]

tomatoes = []
zero_cnt = 0
for z in range(H):
    for x in range(N):
        for y in range(M):
            if board[z][x][y] == 1:
                tomatoes.append((z, x, y, 0))
            if board[z][x][y] == 0:
                zero_cnt += 1


def bfs():
    global zero_cnt

    visited = [[[False] * M for _ in range(N)] for _ in range(H)]
    q = collections.deque(tomatoes)

    while q:
        z, x, y, depth = q.popleft()
        if zero_cnt == 0:
            return depth

        for dz, dx, dy in dir:
            nz, nx, ny = z + dz, x + dx, y + dy

            if 0 <= nz < H and 0 <= nx < N and 0 <= ny < M and board[nz][nx][ny] == 0 and not visited[nz][nx][ny]:
                visited[nz][nx][ny] = True
                q.append((nz, nx, ny, depth + 1))
                zero_cnt -= 1

        if zero_cnt == 0:
            return depth + 1

    return -1


print(bfs())