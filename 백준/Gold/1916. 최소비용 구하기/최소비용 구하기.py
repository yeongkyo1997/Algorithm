import heapq
import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())
M = int(input())

dist = [float('inf')] * (N + 1)
graph = [[] for _ in range(N + 1)]

for _ in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((c, b))


def dijkstra(start, end):
    heap = []
    heapq.heappush(heap, (0, start))

    while heap:
        weight, cur = heapq.heappop(heap)

        if weight > dist[cur]:
            continue

        for cost, p in graph[cur]:
            if dist[p] > cost + weight:
                dist[p] = min(dist[p], cost + weight)
                heapq.heappush(heap, (dist[p], p))

    return dist[end]


start, end = map(int, input().split())
print(dijkstra(start, end))