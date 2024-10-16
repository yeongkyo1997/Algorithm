import sys


if __name__ == '__main__':
    M, N = map(int, input().split())
    arr = list(map(int, input().split()))
    arr.sort()

    start = 1
    end = int(1e9)

    result = 0
    while start <= end:
        # 길이
        mid = start + end >> 1

        cnt = 0
        for a in arr:
            cnt += a // mid

        if cnt >= M:
            start = mid + 1
            result = mid
        else:
            end = mid - 1

    print(result)