import sys

input = lambda: sys.stdin.readline().rstrip()

K, N = map(int, input().split())

arr = [int(input()) for _ in range(K)]


left = 1
right = 1 << 31

result = 0

while left <= right:
    mid = (left + right) // 2
    total = 0

    for a in arr:
        total += a // mid

    if total >= N:
        left = mid + 1
    else:
        right = mid - 1

print(right)
