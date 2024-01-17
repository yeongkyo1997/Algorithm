import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())

board = [0] * N


def check(row):
    for i in range(row):
        if board[row] == board[i] or abs(row - i) == abs(board[i] - board[row]):
            return False

    return True


def dfs(depth):
    if N == depth:
        return 1

    result = 0
    for i in range(N):
        board[depth] = i
        if check(depth):
            result += dfs(depth + 1)

    return result


print(dfs(0))