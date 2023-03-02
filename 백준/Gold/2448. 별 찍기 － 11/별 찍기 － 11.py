import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N = int(input())
arr = [[' '] * 2 * N for _ in range(N)]


def main():
    recursive(0, N - 1, N)
    for i in arr:
        print(''.join(i))


def recursive(i, j, depth):
    if depth == 3:
        arr[i][j] = '*'
        arr[i + 1][j - 1] = '*'
        arr[i + 1][j + 1] = '*'
        for k in range(-2, 3):
            arr[i + 2][j - k] = '*'
        return
    ndepth = depth // 2
    recursive(i, j, ndepth)
    recursive(i + ndepth, j - ndepth, ndepth)
    recursive(i + ndepth, j + ndepth, ndepth)


if __name__ == '__main__':
    main()