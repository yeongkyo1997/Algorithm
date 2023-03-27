import heapq
import sys

input = sys.stdin.readline

N, k = map(int, input().split())
heap = []
result = 0

arr = [list(map(int, input().split())) for _ in range(N)]
arr = sorted(arr, key=lambda x: (x[0], x[1]))

bags = [int(input()) for _ in range(k)]
bags.sort()
idx = 0

for i in range(k):
    while idx < N and arr[idx][0] <= bags[i]:
        heapq.heappush(heap, (-arr[idx][1], arr[idx][1]))
        idx += 1
    if len(heap):
        result += heapq.heappop(heap)[1]
print(result)
