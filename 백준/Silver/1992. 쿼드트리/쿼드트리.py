import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())

board = [list(map(int, (input()))) for _ in range(N)]


def solution(row, col, N):
    tmp = board[row][col]
    check = True
    for i in range(row, row + N):
        for j in range(col, col + N):
            if board[i][j] != tmp:
                check = False
                break
        else:
            continue
        break

    if not check:
        print('(', end='')
        N //= 2
        solution(row, col, N)
        solution(row, col + N, N)
        solution(row + N, col, N)
        solution(row + N, col + N, N)
        print(')', end='')
    else:
        print(tmp, end='')


solution(0, 0, N)