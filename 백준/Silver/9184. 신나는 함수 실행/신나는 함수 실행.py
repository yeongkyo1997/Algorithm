import sys
from functools import cache

input = lambda: sys.stdin.readline().rstrip()


@cache
def w(a, b, c):
    if a <= 0 or b <= 0 or c <= 0:
        return 1

    if a > 20 or b > 20 or c > 20:
        return w(20, 20, 20)

    if a < b < c:
        return w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c)

    return w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1)


def main():
    while True:
        a, b, c = map(int, input().split())

        if a == b == c == -1:
            break
        print(f'w({a}, {b}, {c}) = {w(a, b, c)}')


if __name__ == "__main__":
    main()