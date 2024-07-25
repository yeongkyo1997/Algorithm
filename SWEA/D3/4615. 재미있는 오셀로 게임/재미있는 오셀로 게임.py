T = int(input())

dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, 1, 1, 1, 0, -1, -1, -1]


def color_fill(row, col, color):
    board[row][col] = color
    for d in range(8):
        arr = []
        for i in range(1, 100):
            nr = row + dx[d] * i
            nc = col + dy[d] * i

            if nr < 0 or nc < 0 or nr >= N or nc >= N:
                break
            if board[nr][nc] == 0:
                break
            if board[nr][nc] == color:
                for x, y in arr:
                    board[x][y] = color
                break

            arr.append((nr, nc))


for t in range(1, T + 1):
    N, M = map(int, input().rstrip().split())
    board = [[0] * N for _ in range(N)]

    board[N // 2][N // 2] = 2
    board[N // 2 - 1][N // 2 - 1] = 2
    board[N // 2][N // 2 - 1] = 1
    board[N // 2 - 1][N // 2] = 1

    for _ in range(M):
        col, row, color = map(int, input().rstrip().split())
        col -= 1
        row -= 1
        color_fill(row, col, color)

    black, white = 0, 0

    for i in range(N):
        for j in range(N):
            if board[i][j] == 1:
                black += 1
            if board[i][j] == 2:
                white += 1

    print(f'#{t} {black} {white}')
