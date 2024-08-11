import collections


def block_down(board):
    for col in range(M):
        for row in range(N - 1, -1, -1):
            nx, ny = row, col
            if board[nx][ny] != '.':
                while nx + 1 < N and board[nx + 1][ny] == '.':
                    board[nx + 1][ny] = board[nx][ny]
                    board[nx][ny] = '.'
                    nx += 1


def block_remove(x, y, color):
    path = set()
    q = collections.deque([(x, y)])
    path.add((x, y))

    while q:
        x, y = q.popleft()

        for dx, dy in dir:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == color and (nx, ny) not in path:
                path.add((nx, ny))
                q.append((nx, ny))

    if len(path) >= 4:
        for x, y in path:
            board[x][y] = '.'

        return 1

    return 0


dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]
N = 12
M = 6
board = [list(input()) for _ in range(N)]
result = 0

while True:
    cnt = 0
    for i in range(N):
        for j in range(M):
            if board[i][j] != '.':
                cnt += block_remove(i, j, board[i][j])
    block_down(board)
    if cnt == 0:
        break
    result += 1

print(result)