from heapq import *

heap = []
height = 0
n = int(input())
balloon = sorted([list(map(int, input().split())) for _ in range(n)], key=lambda x: sum(x))

for a, b in balloon:
    height += b
    heappush(heap, -b)
    if height > a + b:
        height += heappop(heap)
print(len(heap))
