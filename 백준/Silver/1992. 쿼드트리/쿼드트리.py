import sys

input = lambda: sys.stdin.readline().rstrip()

N = int(input())
arr = [list(map(int, list(input()))) for _ in range(N)]


def main():
    global arr
    quardTree(0, 0, N)


def check(x, y, N):
    global arr
    cur = arr[x][y]

    for i in range(x, x + N):
        for j in range(y, y + N):
            if cur != arr[i][j]:
                return False
    return True


def quardTree(x, y, N):
    global arr
    if check(x, y, N):
        print(arr[x][y], end='')
        return
    if N == 1:
        print(arr[x][y], end='')
        return

    print('(', end='')
    mid = N // 2
    quardTree(x, y, mid)
    quardTree(x, y + mid, mid)
    quardTree(x + mid, y, mid)
    quardTree(x + mid, y + mid, mid)
    print(')', end='')


if __name__ == '__main__':
    main()