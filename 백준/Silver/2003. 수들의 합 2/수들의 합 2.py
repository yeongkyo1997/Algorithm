import sys

input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))
left = right = 0
s = arr[left]
result = 0

while right < len(arr):
    if s > m:
        s -= arr[left]
        left += 1
        continue
    if s == m:
        result += 1
    if right < len(arr) - 1:
        right += 1
        s += arr[right]
    else:
        right += 1
print(result)
