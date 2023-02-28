import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n, r, c = map(int, input().split())
    print(z(n, r, c))


def z(n, r, c):
    if n == 0:
        return 0
    half = 2 ** (n - 1)
    if r < half and c < half:
        return z(n - 1, r, c)
    elif r < half <= c:
        return half * half + z(n - 1, r, c - half)
    elif r >= half > c:
        return 2 * half * half + z(n - 1, r - half, c)
    else:
        return 3 * half * half + z(n - 1, r - half, c - half)


if __name__ == '__main__':
    main()
