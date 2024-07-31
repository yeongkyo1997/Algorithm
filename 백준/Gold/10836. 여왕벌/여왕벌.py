import copy

M, N = map(int, input().rstrip().split())
board = [[1] * M for _ in range(M)]
dir = [(-1, 0), (0, -1), (-1, -1)]


def change_board(arr):
    x, y = M - 1, 0

    for i in range(3):
        for j in range(arr[i]):
            board[x][y] += i
            if x - 1 >= 0:
                x -= 1
            else:
                y += 1


def spread():
    for i in range(1, M):
        for j in range(1, M):
            max_val = 0
            for dx, dy in dir:
                nx, ny = i + dx, j + dy
                max_val = max(max_val, board[nx][ny])
            board[i][j] = max_val


for _ in range(N):
    arr = list(map(int, input().rstrip().split()))
    change_board(arr)
spread()

for b in board:
    print(*b)