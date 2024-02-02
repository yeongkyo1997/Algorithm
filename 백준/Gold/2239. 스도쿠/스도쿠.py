import sys

sys.setrecursionlimit(10 ** 5)
def input(): return sys.stdin.readline().rstrip()


board = [list(map(int, input())) for _ in range(9)]
cell = []
for i in range(9):
    for j in range(9):
        if board[i][j] == 0:
            cell.append((i, j))


def check(row, col, num):
    for i in range(9):
        if board[row][i] == num or board[i][col] == num:
            return False

    for i in range(3):
        for j in range(3):
            if board[(row // 3) * 3 + i][(col // 3) * 3 + j] == num:
                return False

    return True


def solution(depth):
    if depth == len(cell):
        for i in board:
            print(*i, sep='')
        exit(0)

    for i in range(1, 10):
        x, y = cell[depth]
        if check(x, y, i):
            board[x][y] = i
            solution(depth + 1)
            board[x][y] = 0


solution(0)