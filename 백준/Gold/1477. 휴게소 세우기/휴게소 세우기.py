import sys


def input(): return sys.stdin.readline().rstrip()


N, M, L = map(int, input().split())

arr = [0] + sorted(map(int, input().split())) + [L]


start = 1
end = L - 1

while start <= end:
    mid = (start + end) // 2
    cnt = 0

    for i in range(1, len(arr)):
        if arr[i] - arr[i - 1] > mid:
            cnt += (arr[i] - arr[i - 1] - 1) // mid

    if cnt > M:
        start = mid + 1
    else:
        end = mid - 1
        result = mid
print(result)