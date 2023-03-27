import heapq
import sys

input = sys.stdin.readline

INF = sys.maxsize
N = int(input())
M = int(input())
graph = [[] for _ in range(N + 1)]
distance = [INF] * (N + 1)

for i in range(M):
    arr, b, c = map(int, input().split())
    graph[arr].append((b, c))
s, e = map(int, input().split())


def dijkstra(start):
    heap = []
    distance[start] = 0
    heapq.heappush(heap, (0, start))

    while heap:
        dist, now = heapq.heappop(heap)

        if dist > distance[now]:
            continue

        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(heap, (cost, i[0]))


dijkstra(s)

print(distance[e])
