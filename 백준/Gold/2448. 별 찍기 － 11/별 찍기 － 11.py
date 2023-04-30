import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def draw(row, col):
    arr[row][col] = "*"
    arr[row + 1][col - 1] = "*"
    arr[row + 1][col + 1] = "*"
    for i in range(5):
        arr[row + 2][col - 2 + i] = "*"


def triangle(length, row, col):
    if length == 3:
        draw(row, col)
        return
    triangle(length // 2, row, col)
    triangle(length // 2, row + length // 2, col - length // 2)
    triangle(length // 2, row + length // 2, col + length // 2)


N = int(input())
arr = [[" "] * (2 * N - 1) for _ in range(N)]
triangle(N, 0, N - 1)
for i in range(N):
    print("".join(arr[i]))