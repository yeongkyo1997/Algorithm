def solution(N, k):
    low, high = 1, N * N

    while low < high:
        mid = (low + high) // 2
        cnt = sum(min(mid // i, N) for i in range(1, N + 1))

        if cnt < k:
            low = mid + 1
        else:
            high = mid

    return low


N = int(input())
k = int(input())
print(solution(N, k))