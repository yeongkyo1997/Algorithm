import math
import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

N = int(input())
arr = [int(input()) for _ in range(N)]
arr.sort()

gc = arr[1] - arr[0]
for i in range(2, N):
    gc = math.gcd(gc, arr[i] - arr[i - 1])

print(sum([(arr[i] - arr[i - 1]) // gc - 1 for i in range(1, N)]))
