import sys

input = lambda: sys.stdin.readline().rstrip()


N = int(input())

arr = list(map(int, input().split()))

arr.sort()


left = 0
right = len(arr) - 1

result = []
min_val = float("inf")

while left < right:
    minus = arr[right] + arr[left]

    if minus == 0:
        result = [arr[left], arr[right]]
        min_val = 0
        break
    if min_val > abs(minus):
        min_val = abs(minus)
        result = [arr[left], arr[right]]
        if result == 0:
            break

    if minus < 0:
        left += 1
    else:
        right -= 1


print(*result)
