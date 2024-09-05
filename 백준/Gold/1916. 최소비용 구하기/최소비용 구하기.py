import collections
import heapq
import math
import sys

input = lambda: sys.stdin.readline().rstrip()

N = int(input())
M = int(input())

graph = collections.defaultdict(list)
dist = collections.defaultdict(lambda: math.inf)

for _ in range(M):
    s, e, d = map(int, input().split())
    graph[s].append((e, d))

start, end = map(int, input().split())


def dijkstra(start):
    dist[start] = 0
    heap = []
    heapq.heappush(heap, (dist[start], start))

    while heap:
        depth, x = heapq.heappop(heap)
        if depth > dist[x]:
            continue

        for e, d in graph[x]:
            w = dist[x] + d
            if dist[e] > w:
                dist[e] = w
                heapq.heappush(heap, (dist[e], e))


dijkstra(start)
print(dist[end])