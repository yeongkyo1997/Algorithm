import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N, X = map(int, input().split())

    print(*filter(lambda i: i < X, map(int, input().split())))


if __name__ == '__main__':
    main()
