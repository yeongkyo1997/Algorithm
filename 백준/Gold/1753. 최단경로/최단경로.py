import heapq
import sys


def input(): return sys.stdin.readline().rstrip()


V, E = map(int, input().split())
K = int(input())

dist = [float('inf')] * (V + 1)
graph = [[] for _ in range(V + 1)]

for _ in range(E):
    a, b, c = map(int, input().split())
    graph[a].append((c, b))


def dijkstra(start):
    heap = []
    heapq.heappush(heap, (0, start))
    dist[start] = 0

    while heap:
        weight, cur = heapq.heappop(heap)

        if weight > dist[cur]:
            continue

        for cost, p in graph[cur]:
            if dist[p] > cost + weight:
                dist[p] = min(dist[p], cost + weight)
                heapq.heappush(heap, (dist[p], p))


dijkstra(K)
for i in range(1, V + 1):
    print(str(dist[i]).upper())