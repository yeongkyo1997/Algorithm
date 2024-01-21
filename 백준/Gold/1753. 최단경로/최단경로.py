import sys
from collections import defaultdict
import heapq


def input(): return sys.stdin.readline().rstrip()


V, E = map(int, input().split())
graph = defaultdict(list)
distance = defaultdict(lambda: float('inf'))
start = int(input())

for _ in range(E):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))


def dijkstra(start):
    heap = []
    distance[start] = 0
    heapq.heappush(heap, (0, start))

    while heap:
        dist, now = heapq.heappop(heap)

        if distance[now] < dist:
            continue

        for i in graph[now]:
            cost = dist + i[1]

            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(heap, (cost, i[0]))


dijkstra(start)
for i in range(1, V + 1):
    print(distance[i] if distance[i] != float('inf') else 'INF')