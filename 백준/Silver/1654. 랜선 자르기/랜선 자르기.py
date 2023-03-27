import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def binary_search(left, right):
    while left <= right:
        mid = (left + right) // 2
        cnt = 0
        for i in range(K):
            cnt += arr[i] // mid
        if cnt >= N:
            left = mid + 1
        else:
            right = mid - 1
    return right


K, N = map(int, input().split())
arr = [int(input()) for _ in range(K)]
print(binary_search(1, max(arr)))
