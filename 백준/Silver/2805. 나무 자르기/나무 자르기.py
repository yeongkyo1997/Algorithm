import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N, M = map(int, input().split())
    arr = list(map(int, input().split()))
    left = 0
    right = max(arr)

    while left < right:
        cur = 0
        mid = (left + right) // 2

        for i in arr:
            if i - mid > 0:
                cur += i - mid

        if cur < M:
            right = mid
        else:
            left = mid + 1
    print(left - 1)


if __name__ == '__main__':
    main()