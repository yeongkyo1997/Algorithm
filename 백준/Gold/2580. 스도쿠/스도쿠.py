import sys


def input(): return sys.stdin.readline().rstrip()


board = [list(map(int, input().split())) for _ in range(9)]
zero = []

for i in range(9):
    for j in range(9):
        if board[i][j] == 0:
            zero.append((i, j))


def check(x, y, num):
    for i in range(9):
        if board[x][i] == num:
            return False
        if board[i][y] == num:
            return False

    for i in range((x // 3) * 3, (x // 3) * 3 + 3):
        for j in range((y // 3) * 3, (y // 3) * 3 + 3):
            if board[i][j] == num:
                return False

    return True


def solution(n):
    if n == len(zero):
        for i in board:
            print(*i)
        exit(0)

    x, y = zero[n]
    for i in range(1, 10):
        if check(x, y, i):
            board[x][y] = i
            solution(n + 1)
            board[x][y] = 0


solution(0)