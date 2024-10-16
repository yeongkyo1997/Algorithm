import math

if __name__ == '__main__':
    N = int(input())
    arr = list(map(int, input().split()))
    arr.sort()

    start = 0
    end = N - 1

    min_val = math.inf
    result = ()
    while start < end:
        cur = arr[start] + arr[end]

        if abs(cur) < min_val:
            result = arr[start], arr[end]
            min_val = abs(cur)
        if cur == 0:
            result = arr[start], arr[end]
            break
        if cur > 0:
            end -= 1
        else:
            start += 1

    print(*result)