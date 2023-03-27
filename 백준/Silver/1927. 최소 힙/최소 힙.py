import heapq
import sys

heap = []
result = []
for t in range(int(input())):
    N = int(sys.stdin.readline().rstrip())

    if N == 0:
        if not len(heap):
            result.append(0)
        else:
            result.append(heapq.heappop(heap))
    else:
        heapq.heappush(heap, N)
       
for i in result:
    print(i)
