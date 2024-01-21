import sys
from collections import defaultdict
import heapq


def input(): return sys.stdin.readline().rstrip()


N, K = map(int, input().split())

heap = []
visited = defaultdict(lambda: False)
heapq.heappush(heap, (0, N))

while heap:
    depth, cur = heapq.heappop(heap)
    if cur == K:
        print(depth)
        break

    if 0 <= cur * 2 <= 100000 and not visited[cur * 2]:
        heapq.heappush(heap, (depth, cur * 2))
        visited[cur * 2] = True
    if 0 <= cur + 1 <= 100000 and not visited[cur + 1]:
        heapq.heappush(heap, (depth + 1, cur + 1))
        visited[cur + 1] = True
    if 0 <= cur - 1 <= 100000 and not visited[cur - 1]:
        heapq.heappush(heap, (depth + 1, cur - 1))
        visited[cur - 1] = True