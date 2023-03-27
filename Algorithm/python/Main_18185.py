import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = list(map(int, input().split()))
res = 0
for i in range(n):
    if i < n - 2:
        while arr[i] > 0 and arr[i + 1] > 0 and arr[i + 1] > arr[i + 2]:
            arr[i] -= 1
            arr[i + 1] -= 1
            res += 5
        while arr[i] > 0 and arr[i + 1] > 0 and arr[i + 2] > 0:
            arr[i] -= 1
            arr[i + 1] -= 1
            arr[i + 2] -= 1
            res += 7
    if i < n - 1:
        while arr[i] > 0 and arr[i + 1] > 0:
            arr[i] -= 1
            arr[i + 1] -= 1
            res += 5
    res += arr[i] * 3
print(res)
