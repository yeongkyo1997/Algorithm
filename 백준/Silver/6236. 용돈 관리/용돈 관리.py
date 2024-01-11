import sys


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())

arr = [int(input()) for _ in range(N)]


start = min(arr)
end = sum(arr)

while start <= end:
    mid = (start + end) // 2
    cur = mid
    cnt = 1

    for i in arr:
        if cur < i:
            cur = mid
            cnt += 1
        cur -= i

    if mid < max(arr) or cnt > M:
        start = mid + 1
    else:
        end = mid - 1
        result = mid

print(result)