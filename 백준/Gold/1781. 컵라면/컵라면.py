import heapq
import sys

input = sys.stdin.readline

N = int(input())
arr = sorted([list(map(int, input().split())) for _ in range(N)], key=lambda x: x[0])
heap = []

for i in arr:
    heapq.heappush(heap, i[1])
    if len(heap) > i[0]:
        heapq.heappop(heap)
print(sum(heap))
