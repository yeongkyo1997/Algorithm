import sys
import math


def input(): return sys.stdin.readline().rstrip()


X, Y = map(int, input().split())

percent = math.floor(Y * 100 / X)

if percent >= 99:
    print(-1)
    exit(0)


result = 2 ** 70

start = 1
end = 2 ** 70

while start <= end:
    mid = (start + end) // 2
    nx, ny = X + mid, Y + mid
    cur = math.floor(ny * 100 / nx)

    if cur > percent:
        result = min(result, mid)
        end = mid - 1
    else:
        start = mid + 1

print(result)