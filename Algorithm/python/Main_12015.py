import sys
from bisect import bisect_left

input = lambda: sys.stdin.readline().rstrip()

N = int(input())

array = list(map(int, input().split()))

dp = [1]
x = [array[0]]

for i in range(1, len(array)):
    if array[i] > x[-1]:
        x.append(array[i])
        dp.append(dp[-1] + 1)
    else:
        idx = bisect_left(x, array[i])
        x[idx] = array[i]
print(dp[-1])
