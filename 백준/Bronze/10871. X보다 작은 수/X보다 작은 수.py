import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N, X = map(int, input().split())

    arr = list(map(int, input().split()))
    print(*filter(lambda i: i < X, arr))


if __name__ == '__main__':
    main()