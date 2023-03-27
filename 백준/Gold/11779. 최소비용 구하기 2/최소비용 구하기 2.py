import heapq
import sys
from collections import defaultdict

INF = int(1e9)
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
m = int(input())
graph = defaultdict(list)

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
start, end = map(int, input().split())

dist = [INF] * (n + 1)
pre = [0] * (n + 1)

def dijkstra(start):
    heap = []
    heapq.heappush(heap, (0, start))
    dist[start] = 0
    while heap:
        w, node = heapq.heappop(heap)
        if dist[node] < w:
            continue
        for adj_node, adj_weight in graph[node]:
            cost = w + adj_weight
            if cost < dist[adj_node]:
                dist[adj_node] = cost
                pre[adj_node] = node
                heapq.heappush(heap, (cost, adj_node))

dijkstra(start)
print(dist[end])

path = [end]
cur = end
while cur != start:
    cur = pre[cur]
    path.append(cur)

path.reverse()

print(len(path))
print(' '.join(map(str, path)))