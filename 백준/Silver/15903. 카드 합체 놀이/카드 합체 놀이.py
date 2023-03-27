import heapq
import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))
heap = []
for i in arr:
    heapq.heappush(heap, i)

for i in range(M):
    arr, b = heapq.heappop(heap), heapq.heappop(heap)
    heapq.heappush(heap, arr + b)
    heapq.heappush(heap, arr + b)
print(sum(heap))
