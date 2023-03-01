import itertools
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def main():
    N, M = map(int, input().split())
    arr = list(map(int, input().split()))

    result = 0
    for i in itertools.combinations(arr, 3):
        s = sum(i)
        if M >= s:
            result = max(s, result)

    print(result)


if __name__ == '__main__':
    main()