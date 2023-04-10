import collections
import heapq
import math
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N = int(input())
M = int(input())

dist = [math.inf] * (N + 1)
graph = collections.defaultdict(list)

for _ in range(M):
    a, b, c = map(int, input().split())
    graph[a].append([b, c])

start, end = map(int, input().split())


def dijkstra():
    global dist, graph
    dist[start] = 0
    heap = []
    heapq.heappush(heap, (0, start))

    while heap:
        distance, cur = heapq.heappop(heap)

        if dist[cur] < distance:
            continue

        for i in graph[cur]:
            nNode, nDist = i
            nDist += distance

            if nDist < dist[nNode]:
                dist[nNode] = nDist
                heapq.heappush(heap, (nDist, nNode))


dijkstra()

print(dist[end])