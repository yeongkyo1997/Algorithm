import sys
import heapq
from collections import defaultdict


def input(): return sys.stdin.readline().rstrip()


N, E = map(int, input().split())
graph = defaultdict(list)

for _ in range(E):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))


def dijkstra(start):
    distance = defaultdict(lambda: float('inf'))

    heap = []
    distance[start] = 0
    heapq.heappush(heap, (0, start))

    while heap:
        dist, now = heapq.heappop(heap)

        for i in graph[now]:
            cost = dist + i[1]

            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(heap, (cost, i[0]))
    return distance


v1, v2 = map(int, input().split())
start = 1
dist_start = dijkstra(start)
dist_v1 = dijkstra(v1)
dist_v2 = dijkstra(v2)

v1_len, v2_len = dist_start[v1] + dist_v1[v2] + \
    dist_v2[N], dist_start[v2] + dist_v2[v1] + dist_v1[N]

result = min(v1_len, v2_len)

print(result if result != float('inf') else -1)