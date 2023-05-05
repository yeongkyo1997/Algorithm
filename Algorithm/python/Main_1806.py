import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

n, s = map(int, input().split())
arr = list(map(int, input().split()))

low = 0
high = 0
sum = arr[0]
len = n + 1

while low <= high < n:
    if sum < s:
        high += 1
        if high < n:
            sum += arr[high]
    else:
        len = min(len, high - low + 1)
        sum -= arr[low]
        low += 1

if len == n + 1:
    len = 0
print(len)
