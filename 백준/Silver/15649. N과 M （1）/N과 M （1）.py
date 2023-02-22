import itertools
import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N, M = map(int, input().split())

    arr = list(itertools.permutations(range(1, N + 1), M))
    for i in arr:
        print(*i)


if __name__ == '__main__':
    main()