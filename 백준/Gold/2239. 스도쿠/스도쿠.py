import sys

sys.setrecursionlimit(10 ** 5)


def input(): return sys.stdin.readline().rstrip()


board = [list(map(int, input())) for _ in range(9)]

row = [0] * 9
col = [0] * 9
grid = [0] * 9

empty = []

for r in range(9):
    for c in range(9):
        if board[r][c] != 0:
            val = 1 << (board[r][c] - 1)
            row[r] |= val
            col[c] |= val
            grid[r // 3 * 3 + c // 3] |= val
        else:
            empty.append((r, c))


def check(mask):
    full_mask = 0b111111111
    return full_mask & ~mask


def solution(depth):
    if depth == len(empty):
        for r in range(9):
            print(*board[r], sep='')
        exit(0)

    r, c = empty[depth]
    candidates = check(
        row[r] | col[c] | grid[r // 3 * 3 + c // 3])

    for num in range(1, 10):
        if candidates & (1 << (num - 1)):
            board[r][c] = num
            val = 1 << (num - 1)
            row[r] |= val
            col[c] |= val
            grid[r // 3 * 3 + c // 3] |= val

            solution(depth + 1)

            board[r][c] = 0
            row[r] &= ~val
            col[c] &= ~val
            grid[r // 3 * 3 + c // 3] &= ~val


solution(0)