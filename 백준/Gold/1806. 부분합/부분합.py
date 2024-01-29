import sys


def input(): return sys.stdin.readline().rstrip()


N, S = map(int, input().split())
arr = list(map(int, input().split()))

left = 0
right = -1
total = 0
result = float('inf')

while left < N:
    if total >= S:
        result = min(result, right - left + 1)
        total -= arr[left]
        left += 1
    else:
        right += 1
        if right < N:
            total += arr[right]
        else:
            break

print(result if result != float('inf') else 0)