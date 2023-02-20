import sys
import heapq

input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))
heap = []
for i in arr:
    heapq.heappush(heap, i)

for i in range(m):
    a, b = heapq.heappop(heap), heapq.heappop(heap)
    heapq.heappush(heap, a + b)
    heapq.heappush(heap, a + b)
print(sum(heap))
