import sys

# sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = [0] * 20002
tmp = 0
SUM = 0

arr[1:n + 1] = list(map(int, input().split()))

for i in range(2, n + 1):
    arr[i] += arr[i - 1]

for i in range(1, n + 1):
    arr[i + n] += arr[i] + arr[n]

for i in range(0, n):
    for j in range(i + 1, i + n + 1):
        tmp = arr[j] - arr[i]
        if tmp < 0:
            SUM += ((tmp * (-1)) - 1) // arr[n] + 1
print(SUM)