import sys


def input(): return sys.stdin.readline().rstrip()


N, C = map(int, input().split())

arr = [int(input()) for _ in range(N)]


arr.sort()

start = 1
end = 2 ** 30

while start <= end:
    mid = (start + end) // 2
    cur = arr[0]
    cnt = 1

    for i in range(1, len(arr)):
        if arr[i] >= cur + mid:
            cnt += 1
            cur = arr[i]

    if cnt >= C:
        start = mid + 1
        result = mid
    else:
        end = mid - 1

print(result)