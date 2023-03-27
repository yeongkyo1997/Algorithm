import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def main():
    N, M = map(int, input().split())

    arr = list(map(int, input().split()))

    left = 1
    right = 2000000000

    while left <= right:
        total = 0
        mid = (left + right) // 2

        for i in arr:
            if i - mid > 0:
                total += i - mid

        if total >= M:
            left = mid + 1
        else:
            right = mid - 1

    print(left - 1)


if __name__ == '__main__':
    main()