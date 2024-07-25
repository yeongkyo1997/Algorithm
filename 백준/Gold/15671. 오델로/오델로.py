N = int(input())

board = [['.'] * 6 for _ in range(6)]
board[2][2] = board[3][3] = 'W'
board[2][3] = board[3][2] = 'B'

dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, 1, 1, 1, 0, -1, -1, -1]


def change(row, col, color):
    board[row][col] = color
    for d in range(8):
        arr = []
        nx = row
        ny = col

        while True:
            nx += dx[d]
            ny += dy[d]
            if nx < 0 or ny < 0 or nx >= 6 or ny >= 6:
                break

            if board[nx][ny] == '.':
                break
            if board[nx][ny] == color:
                for x, y in arr:
                    board[x][y] = color
                break
            arr.append((nx, ny))


for i in range(N):
    row, col = map(int, input().rstrip().split())
    row -= 1
    col -= 1

    if i % 2 == 0:
        change(row, col, 'B')
    else:
        change(row, col, 'W')

black = 0
white = 0

for b in board:
    black += b.count('B')
    white += b.count('W')
    print(*b, sep='')

if black > white:
    print('Black')
else:
    print('White')