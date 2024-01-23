N = int(input())

board = [list(map(int, input().split())) for _ in range(N)]


def check(row, col, N):
    start = board[row][col]
    for i in range(row, row + N):
        for j in range(col, col + N):
            if board[i][j] != start:
                return False
    return True


def solution(row, col, N):
    global white, blue
    if check(row, col, N):
        if board[row][col] == 0:
            white += 1
        else:
            blue += 1
        return

    solution(row, col, N // 2)
    solution(row, col + N // 2, N // 2)
    solution(row + N // 2, col, N // 2)
    solution(row + N // 2, col + N // 2, N // 2)


white = blue = 0
solution(0, 0, N)
print(white)
print(blue)