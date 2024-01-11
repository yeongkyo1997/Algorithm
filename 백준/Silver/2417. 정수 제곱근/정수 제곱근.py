import sys


def input(): return sys.stdin.readline().rstrip()


n = int(input())

start = 0
end = 2 ** 63 - 1

while start <= end:
    mid = (start + end) // 2

    if mid ** 2 < n:
        start = mid + 1
    else:
        end = mid - 1

print(start)