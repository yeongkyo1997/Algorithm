import heapq
import sys


def input(): return sys.stdin.readline().rstrip()


V, E = map(int, input().split())

graph = [[] for _ in range(V + 1)]

for _ in range(E):
    a, b, c = map(int, input().split())
    graph[a].append((c, b))
    graph[b].append((c, a))


def dijkstra(start):
    dist = [float('inf')] * (V + 1)

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
    return dist


v1, v2 = map(int, input().split())
dist_1 = dijkstra(1)
dist_v1 = dijkstra(v1)
dist_v2 = dijkstra(v2)

result = min(dist_1[v1] + dist_v1[v2] + dist_v2[V],
             dist_1[v2] + dist_v2[v1] + dist_v1[V])
print(result if result != float('inf') else -1)