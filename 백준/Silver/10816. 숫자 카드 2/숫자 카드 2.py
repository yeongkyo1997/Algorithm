import collections
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    arr = list(map(int, input().split()))
    m = int(input())
    check = list(map(int, input().split()))
    d = collections.defaultdict(int)
    for i in arr:
        if i in d:
            d[i] += 1
        else:
            d[i] = 1
    for i in check:
        if i in d:
            print(d[i], end=' ')
        else:
            print(0, end=' ')


if __name__ == '__main__':
    main()