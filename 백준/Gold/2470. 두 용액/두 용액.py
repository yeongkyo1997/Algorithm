import math
import sys

input = lambda: sys.stdin.readline().rstrip()


if __name__ == '__main__':
    N = int(input())
    arr = list(map(int, input().split()))
    arr.sort()

    start = 0
    end = N - 1
    total = math.inf
    result = []

    while start < end:
        left = arr[start]
        right = arr[end]

        _sum = right + left

        if abs(_sum) < total:
            total = abs(_sum)
            result = [left, right]
            if total == 0:
                break
        if _sum < 0:
            start += 1
        else:
            end -= 1
    print(*result)
