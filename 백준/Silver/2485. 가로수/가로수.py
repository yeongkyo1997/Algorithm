import math
import sys


def input(): return sys.stdin.readline().rstrip()


n = int(input())
arr = [int(input()) for _ in range(n)]

dist = []
for i in range(1, len(arr)):
    dist.append(arr[i] - arr[i - 1])


g = math.gcd(*dist)

result = 0
for i in dist:
    result += i // g - 1

print(result)