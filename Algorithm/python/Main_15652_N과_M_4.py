import itertools
import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N, M = map(int, input().split())
    for i in itertools.combinations_with_replacement(range(1, N + 1), M):
        print(*i)


if __name__ == '__main__':
    main()
