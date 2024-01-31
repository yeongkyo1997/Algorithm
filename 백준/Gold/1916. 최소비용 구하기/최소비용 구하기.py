import heapq
import sys


def input(): return sys.stdin.readline().rstrip()
# sys.stdin = open('Main_1916.txt', 'r')


N = int(input())
M = int(input())

graph = [[] for _ in range(N + 1)]

for _ in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((c, b))


def dijkstra(start):
    heap = []
    heapq.heappush(heap, (0, start))

    while heap:
        weight, cur = heapq.heappop(heap)

        if weight > dist[cur]:
            continue

        for cost, p in graph[cur]:
            if cost + weight < dist[p]:
                dist[p] = cost + weight
                heapq.heappush(heap, (dist[p], p))


start, end = map(int, input().split())
dist = [float('inf')] * (N + 1)
dijkstra(start)

print(dist[end])