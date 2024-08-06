import collections

dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]

M, N = map(int, input().rstrip().split())

board = [list(map(int, input().rstrip().split())) for _ in range(N)]

tomato = []
zero_cnt = 0
for i in range(N):
    for j in range(M):
        if board[i][j] == 0:
            zero_cnt += 1
        elif board[i][j] == 1:
            tomato.append((i, j, 0))


def bfs():
    global zero_cnt
    q = collections.deque(tomato)
    visited = [[False] * M for _ in range(N)]

    while q:
        x, y, depth = q.popleft()
        for dx, dy in dir:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny] and board[nx][ny] == 0:
                visited[nx][ny] = True
                q.append((nx, ny, depth + 1))
                zero_cnt -= 1
                if zero_cnt == 0:
                    return depth + 1
    return -1


if zero_cnt == 0:
    print(0)
else:
    print(bfs())