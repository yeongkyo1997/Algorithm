import itertools
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def main():
    N, M = map(int, input().split())
    arr = map(int, input().split())
    arr = sorted(arr)

    for i in itertools.permutations(arr, M):
        print(*i)


if __name__ == '__main__':
    main()