import collections

M, N, H = map(int, input().rstrip().split())
dx = [0, 0, -1, 1, 0, 0]
dy = [-1, 1, 0, 0, 0, 0]
dz = [0, 0, 0, 0, -1, 1]

board = [[list(map(int, input().rstrip().split())) for _ in range(N)] for _ in range(H)]

tomatoes = collections.deque()
zero_cnt = 0

for i in range(H):
    for j in range(N):
        for k in range(M):
            if board[i][j][k] == 1:
                tomatoes.append((i, j, k, 0))
            elif board[i][j][k] == 0:
                zero_cnt += 1


def bfs():
    global zero_cnt
    q = tomatoes

    while q:
        x, y, z, depth = q.popleft()

        for d in range(len(dx)):
            nx = x + dx[d]
            ny = y + dy[d]
            nz = z + dz[d]

            if nx < 0 or nx >= H or ny < 0 or ny >= N or nz < 0 or nz >= M:
                continue

            if board[nx][ny][nz] == 0:
                board[nx][ny][nz] = 1
                q.append((nx, ny, nz, depth + 1))
                zero_cnt -= 1
        if zero_cnt == 0:
            return depth + 1

    return -1


if zero_cnt == 0:
    print(0)
else:
    print(bfs())