import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    arr = [list(map(int, input().split())) for _ in range(n)]
    print(*paper(arr, 0, 0, n), sep=' ')


def paper(arr, x, y, n):
    if n == 1:
        return 1, 0 if arr[x][y] == 0 else 1
    a = paper(arr, x, y, n // 2)
    b = paper(arr, x, y + n // 2, n // 2)
    c = paper(arr, x + n // 2, y, n // 2)
    d = paper(arr, x + n // 2, y + n // 2, n // 2)
    if a == b == c == d:
        return a
    return a[0] + b[0] + c[0] + d[0], a[1] + b[1] + c[1] + d[1]


if __name__ == '__main__':
    main()
