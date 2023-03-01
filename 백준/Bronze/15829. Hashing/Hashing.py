import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def main():
    L = int(input())
    arr = list(input())

    total = 0
    for i, x in enumerate(arr):
        total += (ord(x) - ord('a') + 1) * (31 ** i)

    print(total % 1234567891)


if __name__ == '__main__':
    main()