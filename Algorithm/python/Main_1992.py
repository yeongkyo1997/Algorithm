import sys

input = lambda: sys.stdin.readline().rstrip()

N = int(input())

arr = [list(map(int, list(input()))) for _ in range(N)]


def check(n, x, y):
    val = arr[x][y]

    for i in range(x, x + n):
        for j in range(y, y + n):
            if val != arr[i][j]:
                return False
    return True


def solve(n, x, y):
    if check(n, x, y):
        print(arr[x][y], end='')
        return

    mid = n // 2

    print('(', end='')
    solve(mid, x, y)
    solve(mid, x, y + mid)
    solve(mid, x + mid, y)
    solve(mid, x + mid, y + mid)
    print(')', end='')


solve(N, 0, 0)
