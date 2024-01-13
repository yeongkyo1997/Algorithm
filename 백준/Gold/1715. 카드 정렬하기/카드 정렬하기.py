import sys
import heapq

N = int(input())

heap = []

for _ in range(N):
    num = int(input())
    heapq.heappush(heap, num)

result = 0
while len(heap) != 1:
    a, b = heapq.heappop(heap), heapq.heappop(heap)
    result += a + b
    heapq.heappush(heap, a + b)

print(result)