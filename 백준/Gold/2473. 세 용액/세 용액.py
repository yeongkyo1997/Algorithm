import math
import sys

input = lambda: sys.stdin.readline().rstrip()

if __name__ == '__main__':
    N = int(input())

    arr = list(map(int, input().split()))
    arr.sort()

    result = ()
    min_val = math.inf

    for i in range(N - 2):
        start = i + 1
        end = N - 1

        while start < end:
            left_val = arr[start]
            right_val = arr[end]

            total = right_val + left_val + arr[i]
            if min_val > abs(total):
                min_val = abs(total)
                result = arr[i], left_val, right_val
            # 용액이 양수라면
            if total < 0:
                start += 1
            else:
                end -= 1

    print(*result)