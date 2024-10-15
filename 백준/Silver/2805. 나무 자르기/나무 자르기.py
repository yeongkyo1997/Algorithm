if __name__ == '__main__':
    N, M = map(int, input().split())

    arr = list(map(int, input().split()))

    start = 0
    end = int(1e9)

    result = 0

    while start <= end:
        mid = start + end >> 1
        total = 0

        for a in arr:
            if a - mid >= 0:
                total += a - mid

        if total < M:
            end = mid - 1
        else:
            start = mid + 1
            result = mid

    print(result)