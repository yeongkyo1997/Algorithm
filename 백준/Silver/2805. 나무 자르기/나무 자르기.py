import sys


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())

arr = list(map(int, input().split()))


left, right = 1, 1000000000

while left <= right:
    mid = (left + right) // 2
    cnt = 0

    for i in arr:
        if i > mid:
            cnt += i - mid

    if cnt >= M:
        left = mid + 1
    else:
        right = mid - 1

print(right)