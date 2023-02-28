import sys

input = lambda: sys.stdin.readline().rstrip()


# 1992 쿼드트리
def main():
    n = int(input())
    arr = [list(map(int, input())) for _ in range(n)]
    print(quad(arr, 0, 0, n))


def quad(arr, x, y, n):
    if n == 1:
        return str(arr[x][y])
    a = quad(arr, x, y, n // 2)
    b = quad(arr, x, y + n // 2, n // 2)
    c = quad(arr, x + n // 2, y, n // 2)
    d = quad(arr, x + n // 2, y + n // 2, n // 2)
    if a == b == c == d and len(a) == 1:
        return a
    return '(' + a + b + c + d + ')'


if __name__ == '__main__':
    main()
