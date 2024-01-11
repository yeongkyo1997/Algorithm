import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())
arr = list(map(int, input().split()))
M = int(input())


start = 0
end = max(arr)

while start <= end:
    mid = (start + end) // 2
    cur = 0

    for i in arr:
        cur += min(mid, i)

    if cur <= M:
        start = mid + 1
        result = mid
    else:
        end = mid - 1
print(result)