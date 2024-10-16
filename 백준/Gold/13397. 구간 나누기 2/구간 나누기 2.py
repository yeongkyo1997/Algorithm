import heapq
import math

if __name__ == '__main__':
    N, M = map(int, input().split())
    arr = list(map(int, input().split()))

    left = 0
    right = sum(arr)

    result = 0
    while left <= right:
        # 구간의 최댓값
        mid = (left + right) // 2

        min_val = math.inf
        max_val = -math.inf
        # 구간은 처음부터 1개임
        cnt = 1
        for a in arr:
            min_val = min(a, min_val)
            max_val = max(a, max_val)
            if max_val - min_val > mid:
                cnt += 1
                min_val = a
                max_val = a

        # 구간이 더 많다면-> 값을 늘려야 됨
        if cnt > M:
            left = mid + 1
        else:
            right = mid - 1
            result = mid

    print(result)