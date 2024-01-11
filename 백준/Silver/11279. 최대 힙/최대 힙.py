import sys
import heapq


def input(): return sys.stdin.readline().rstrip()


n = int(input())
heap = []

for _ in range(n):
    x = int(input())

    if x == 0:
        print(heapq.heappop(heap)[1] if heap else 0)
    else:
        heapq.heappush(heap, (-x, x))