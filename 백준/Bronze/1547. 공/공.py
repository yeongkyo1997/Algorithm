import sys

input = lambda: sys.stdin.readline().rstrip()

arr = [False] * 3
arr[0] = True

for _ in range(int(input())):
    a, b = map(int, input().split())
    arr[a - 1], arr[b - 1] = arr[b - 1], arr[a - 1]

for i in range(len(arr)):
    if arr[i]:
        print(i + 1)