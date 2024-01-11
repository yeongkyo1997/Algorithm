import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())

start = 1
end = N

while start <= end:
    mid = (start + end) // 2

    if mid ** 2 == N:
        print(mid)
        break
    elif mid ** 2 < N:
        start = mid + 1
    else:
        end = mid - 1