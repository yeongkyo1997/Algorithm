import sys
import heapq, collections

input = lambda: sys.stdin.readline().rstrip()


def dijkstra():
    dist = collections.defaultdict(lambda: float("inf"))
    path = collections.defaultdict(lambda: -1)
    dist[start] = 0
    heap = [(0, start)]

    while heap:
        weight, cur = heapq.heappop(heap)

        if dist[cur] < weight:
            continue

        for w, x in graph[cur]:
            if dist[x] > weight + w:
                dist[x] = weight + w
                path[x] = cur
                heapq.heappush(heap, (dist[x], x))

    print(dist[end])

    cur = end

    result = []
    while path[cur] != -1:
        result.append(cur)
        cur = path[cur]

    result.append(start)
    print(len(result))
    print(*result[::-1])


N = int(input())
M = int(input())

graph = collections.defaultdict(lambda: [])

for _ in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((c, b))

start, end = map(int, input().split())

dijkstra()
