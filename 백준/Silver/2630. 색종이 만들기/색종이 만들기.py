N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]


def is_paper(row, col, size):
    color = board[row][col]

    for i in range(row, row + size):
        for j in range(col, col + size):
            if board[i][j] != color:
                return False

    return True


blue = 0
white = 0


def dfs(row, col, size):
    global blue, white

    if is_paper(row, col, size):
        if board[row][col] == 0:
            white += 1
        else:
            blue += 1
        return

    dfs(row, col, size // 2)
    dfs(row, col + size // 2, size // 2)
    dfs(row + size // 2, col, size // 2)
    dfs(row + size // 2, col + size // 2, size // 2)


dfs(0, 0, N)
print(white)
print(blue)