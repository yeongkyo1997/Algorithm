import sys


def input(): return sys.stdin.readline().rstrip()


K, N = map(int, input().split())

arr = [int(input()) for _ in range(K)]


start = 1
end = max(arr)

while start <= end:
    mid = (start + end) // 2
    cnt = sum(i // mid for i in arr)

    if cnt >= N:
        start = mid + 1
    else:
        end = mid - 1

print(end)