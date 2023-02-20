import sys
import heapq

input = sys.stdin.readline

n = int(input())
heap = []
result = 0

arr = sorted([list(map(int, input().split())) for _ in range(n)], key=lambda x: x[1])

for i in range(n):
    heapq.heappush(heap, arr[i][0])
    if len(heap) > arr[i][1]:
        heapq.heappop(heap)
print(sum(heap))
