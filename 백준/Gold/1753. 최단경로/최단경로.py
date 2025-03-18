import sys
from collections import defaultdict
import math
import heapq

input = lambda: sys.stdin.readline().rstrip()


def dijkstra(start):
    dist = defaultdict(lambda: float("inf"))
    dist[start] = 0

    heap = [(dist[start], start)]

    while heap:
        weight, x = heapq.heappop(heap)
        if weight > dist[x]:
            continue

        for w, v in graph[x]:
            if dist[v] > weight + w:
                dist[v] = weight + w
                heapq.heappush(heap, (dist[v], v))

    return dist


V, E = map(int, input().split())
start = int(input())

graph = defaultdict(lambda: [])

for _ in range(E):
    u, v, w = map(int, input().split())
    graph[u].append((w, v))

dist = dijkstra(start)

for i in range(1, V + 1):
    if dist[i] == float("inf"):
        print("INF")
    else:
        print(dist[i])
