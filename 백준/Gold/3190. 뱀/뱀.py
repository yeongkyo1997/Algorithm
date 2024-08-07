import collections

dir = [(0, 1), (1, 0), (0, -1), (-1, 0)]

N = int(input())
K = int(input())

snake = collections.deque()
snake.append((0, 0))
board = [[0] * N for _ in range(N)]
board[0][0] = 1

for _ in range(K):
    r, c = map(int, input().split())
    board[r - 1][c - 1] = 2

L = int(input())
turn = {}
for _ in range(L):
    X, C = input().split()
    turn[int(X)] = C


def move_snake():
    result = 0
    d = 0
    x, y = snake[0]
    nx, ny = x, y
    while True:
        dx, dy = dir[d]
        nx += dx
        ny += dy
        result += 1
        if nx < 0 or nx >= N or ny < 0 or ny >= N:
            break
        if board[nx][ny] == 1:
            break

        if board[nx][ny] == 2:
            board[nx][ny] = 1
            snake.append((nx, ny))
        if board[nx][ny] == 0:
            snake.append((nx, ny))
            board[nx][ny] = 1
            rx, ry = snake.popleft()
            board[rx][ry] = 0

        if result in turn.keys():
            if turn[result] == 'L':
                d = (d - 1) % 4
            else:
                d = (d + 1) % 4
    return result


print(move_snake())