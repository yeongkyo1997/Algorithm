import sys
import heapq, collections

input = lambda: sys.stdin.readline().rstrip()


def dijkstra(start, end):
    dist = collections.defaultdict(lambda: float("inf"))
    dist[start] = 0
    heap = [(0, start)]

    while heap:
        weight, cur = heapq.heappop(heap)

        if weight > dist[cur]:
            continue

        for w, x in graph[cur]:
            if dist[x] > weight + w:
                dist[x] = weight + w
                heapq.heappush(heap, (dist[x], x))

    return dist[end]


N = int(input())
M = int(input())


graph = collections.defaultdict(lambda: [])

for _ in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((c, b))

start, end = map(int, input().split())
print(dijkstra(start, end))
