import sys

input = lambda: sys.stdin.readline().rstrip()


N = int(input())

arr = [int(input()) for _ in range(N)]
plus = [a for a in arr if a > 0]
minus = [a for a in arr if a <= 0]
arr = sorted(minus)[::-1] + sorted(plus)
result = sum(arr)
left = len(arr) - 2
right = len(arr) - 1

while left >= 0:
    if arr[left] * arr[right] > arr[left] + arr[right]:
        result -= arr[left] + arr[right]
        result += arr[left] * arr[right]
        left -= 2
        right -= 2
    else:
        left -= 1
        right -= 1


print(result)
