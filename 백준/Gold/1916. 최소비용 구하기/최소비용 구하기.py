import collections
import heapq
import math

N = int(input())
M = int(input())

graph = collections.defaultdict(list)

for _ in range(M):
    start, end, cost = map(int, input().split())
    graph[start].append((end, cost))

s, e = map(int, input().split())

dist = collections.defaultdict(lambda: math.inf)


def dijkstra(start):
    dist[start] = 0
    heap = [(0, start)]

    while heap:
        cur_dist, cur_node = heapq.heappop(heap)

        if cur_dist > dist[cur_node]:
            continue

        for end, weight in graph[cur_node]:
            total = cur_dist + weight

            if total < dist[end]:
                dist[end] = total
                heapq.heappush(heap, (total, end))


dijkstra(s)
print(dist[e])