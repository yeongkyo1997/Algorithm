import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def main():
    N = int(input())

    for i in range(N, 0, -1):
        print(' ' * (N - i) + '*' * (2 * i - 1))


if __name__ == '__main__':
    main()