import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())
arr = [int(input()) for _ in range(N)]


def sol(arr, M):
    left, right = 1, arr[0] * M
    result = 0

    while left <= right:
        mid = left + (right - left) // 2
        sum = 0
        for j in arr:
            sum += (mid // j)

        if sum < M:
            left = mid + 1
        else:
            result = mid
            right = mid - 1

    return result


print(sol(arr, M))