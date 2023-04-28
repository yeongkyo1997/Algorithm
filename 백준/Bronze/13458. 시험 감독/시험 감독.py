import sys
import math

input = sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))
b, c = map(int, input().split())
result = 0

for i in a:
    tmp = i - b
    result += 1
    if tmp > 0:
        result += math.ceil(tmp / c)
print(result)  # 131
