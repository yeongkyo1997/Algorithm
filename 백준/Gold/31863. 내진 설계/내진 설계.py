import collections

dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]

N, M = map(int, input().split())

board = [list(input()) for _ in range(N)]

main_list = []
sub_list = []

sx, sy = -1, -1
for row in range(N):
    for col in range(M):
        if board[row][col] == '@':
            sx, sy = row, col
            break


def bfs(x, y):
    q = collections.deque([(x, y, 2)])

    while q:
        x, y, end = q.popleft()
        for dx, dy in dir:
            for i in range(1, end + 1):
                nx, ny = x + dx * i, y + dy * i

                if 0 <= nx < N and 0 <= ny < M:
                    if board[nx][ny] == '|':
                        break
                    elif board[nx][ny] == '#':
                        board[nx][ny] = '*'
                    elif board[nx][ny] == '*':
                        board[nx][ny] = '0'
                        q.append((nx, ny, 1))


bfs(sx, sy)
broken = 0
non_broken = 0
for b in board:
    broken += b.count('0')
    non_broken += b.count('*') + b.count('#')

print(broken, non_broken)