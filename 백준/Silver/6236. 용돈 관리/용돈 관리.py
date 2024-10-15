import sys


if __name__ == '__main__':
    N, M = map(int, input().split())
    arr = [int(input()) for _ in range(N)]
    max_val = max(arr)
    left = 1
    right = int(1e10)
    result = 0

    while left <= right:
        # 목표 인출 금액(조정해야할 값임)
        mid = left + right >> 1
        # 현재 가지고 있는돈
        cur = mid
        cnt = 1

        for a in arr:
            if cur < a:
                cur = mid
                cnt += 1
            cur -= a

        if cnt > M or mid < max_val:
            left = mid + 1
        else:
            right = mid - 1
            result = mid

    print(result)