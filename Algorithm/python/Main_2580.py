import sys

input = lambda: sys.stdin.readline().rstrip()
print = lambda x: sys.stdout.write(str(x))

arr = [list(map(int, input().split())) for _ in range(9)]
point = []

for i in range(9):
    for j in range(9):
        if arr[i][j] == 0:
            point.append((i, j))


def check(p, num):
    for i in range(0, 9):
        if arr[p[0]][i] == num:
            return False
        if arr[i][p[1]] == num:
            return False

    for i in range(p[0] // 3 * 3, p[0] // 3 * 3 + 3):
        for j in range(p[1] // 3 * 3, p[1] // 3 * 3 + 3):
            if arr[i][j] == num:
                return False

    return True


def solve(depth):
    if depth == len(point):
        for i in range(9):
            for j in range(9):
                print(arr[i][j])
                print(' ')
            print('\n')
        exit(0)

    for i in range(1, 10):
        if check(point[depth], i):
            arr[point[depth][0]][point[depth][1]] = i
            solve(depth + 1)
            arr[point[depth][0]][point[depth][1]] = 0


solve(0)
