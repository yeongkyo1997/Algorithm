import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def main():
    n, k = map(int, input().split())
    arr = [i for i in range(1, n + 1)]
    res = []
    idx = 0
    while arr:
        idx = (idx + k - 1) % len(arr)
        res.append(arr.pop(idx))
    print('<' + ', '.join(map(str, res)) + '>')


if __name__ == '__main__':
    main()