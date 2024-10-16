if __name__ == '__main__':
    N, M = map(int, input().split())
    arr = [int(input()) for _ in range(N)]
    arr.sort()
    left = 1
    right = int(1e9)

    result = 0
    while left <= right:
        mid = (left + right) // 2

        cnt = 1
        cur = arr[0]

        for a in arr:
            if a - cur >= mid:
                cnt += 1
                cur = a

        if cnt >= M:
            left = mid + 1
            result = mid
        else:
            right = mid - 1

    print(result)