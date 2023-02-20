import sys
import heapq

input = sys.stdin.readline

n = int(input())

arr = [list(map(int, input().split())) for _ in range(n)]
heap = []

arr = sorted(arr, key=lambda x: x[0])
heapq.heappush(heap, arr[0][1])

for i in range(1, len(arr)):
    if heap[0] <= arr[i][0]:
        heapq.heappop(heap)
    heapq.heappush(heap, arr[i][1])
print(len(heap))
