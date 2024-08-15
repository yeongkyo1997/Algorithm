import copy
import math

dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def move_down(board):
    for col in range(W):
        for row in range(H - 1, -1, -1):
            idx = row
            if board[row][col] > 0:
                while idx + 1 < H and board[idx + 1][col] == 0:
                    board[idx + 1][col] = board[idx][col]
                    board[idx][col] = 0
                    idx += 1


def destroy(board, x, y, size):
    board[x][y] = 0

    for i in range(size):
        for dx, dy in dir:
            nx, ny = x + dx * i, y + dy * i
            if 0 <= nx < H and 0 <= ny < W and board[nx][ny] != 0:
                destroy(board, nx, ny, board[nx][ny])


def block_cnt(board):
    return sum(sum(1 for cell in row if cell != 0) for row in board)


def dfs(path, depth):
    global result
    if depth == N:
        tmp = copy.deepcopy(board)
        for col in path:
            row = 0
            while row < H and tmp[row][col] == 0:
                row += 1
            if row < H:
                if tmp[row][col] == 0:
                    return
                destroy(tmp, row, col, tmp[row][col])
                move_down(tmp)
        result = min(result, block_cnt(tmp))
        return
    for i in range(W):
        dfs(path + [i], depth + 1)


for t in range(1, int(input()) + 1):
    N, W, H = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(H)]
    result = math.inf
    dfs([], 0)

    print(f'#{t} {result}')
