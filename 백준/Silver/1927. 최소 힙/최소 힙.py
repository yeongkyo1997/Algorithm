import heapq
import sys

input = lambda: sys.stdin.readline().rstrip()

heap = []
for _ in range(int(input())):
    x = int(input())
    if x == 0:
        if heap:
            print(heapq.heappop(heap))
        else:
            print(0)
    else:
        heapq.heappush(heap, x)