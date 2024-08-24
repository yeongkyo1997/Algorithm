import collections
import heapq
import math

V, E = map(int, input().split())

K = int(input())

graph = collections.defaultdict(list)
for _ in range(E):
    s, e, d = map(int, input().split())
    graph[s].append((e, d))

dist = collections.defaultdict(lambda: math.inf)


def dijkstra():
    heap = []
    dist[K] = 0
    heapq.heappush(heap, (dist[K], K))

    while heap:
        depth, x = heapq.heappop(heap)
        if depth > dist[x]:
            continue

        for e, d in graph[x]:
            if dist[e] > dist[x] + d:
                dist[e] = dist[x] + d
                heapq.heappush(heap, (dist[e], e))


dijkstra()

for i in range(1, V + 1):
    if dist[i] == math.inf:
        print('INF')
    else:
        print(dist[i])