import sys
from collections import deque

N = int(input())

arr = sorted([list(map(int, input().split()))
             for _ in range(N)], key=lambda x: (x[0], x[1]))

for a, b in arr:
    print(a, b)