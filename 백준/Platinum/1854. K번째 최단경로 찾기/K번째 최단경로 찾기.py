import heapq
from collections import defaultdict


def k_shortest_paths(n, k, edges):
    graph = defaultdict(list)
    for a, b, c in edges:
        graph[a].append((b, c))

    distances = [[float('inf')] * k for _ in range(n + 1)]
    distances[1][0] = 0
    pq = [(0, 1)]

    while pq:
        dist, node = heapq.heappop(pq)

        for neighbor, weight in graph[node]:
            new_dist = dist + weight
            if new_dist < distances[neighbor][-1]:
                distances[neighbor][-1] = new_dist
                distances[neighbor].sort()
                heapq.heappush(pq, (new_dist, neighbor))

    return distances


n, m, k = map(int, input().split())
edges = [list(map(int, input().split())) for _ in range(m)]

result = k_shortest_paths(n, k, edges)

for i in range(1, n + 1):
    if result[i][k - 1] == float('inf'):
        print(-1)
    else:
        print(result[i][k - 1])