if __name__ == '__main__':
    S, C = map(int, input().split())
    arr = [int(input()) for _ in range(S)]

    start = 1
    end = max(arr)

    max_val = 0
    while start <= end:
        # 치킨에 넣을 파의 길이
        mid = start + end >> 1

        # 파의 개수
        cnt = sum(a // mid for a in arr)

        if cnt >= C:
            start = mid + 1
            max_val = mid
        else:
            end = mid - 1

    result = sum(arr) - (C * max_val)
    print(result)