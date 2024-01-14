import heapq


def dijkstra(start, n, k, ways):
    cost = [[-1 for _ in range(21)] for _ in range(n + 1)]
    q = []

    cost[start][0] = 0
    heapq.heappush(q, (0, start, 0))

    while q:
        here_c, here, cnt = heapq.heappop(q)

        if here_c > cost[here][cnt]:
            continue

        for there, there_cost in ways[here]:
            new_cost = here_c + there_cost

            if cnt < k and (cost[there][cnt + 1] == -1 or cost[there][cnt + 1] > here_c):
                cost[there][cnt + 1] = here_c
                heapq.heappush(q, (here_c, there, cnt + 1))

            if cost[there][cnt] == -1 or cost[there][cnt] > new_cost:
                cost[there][cnt] = new_cost
                heapq.heappush(q, (new_cost, there, cnt))

    min_cost = min(c for c in cost[n] if c != -1)
    return min_cost


n, m, k = map(int, input().split())
ways = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    ways[a].append((b, c))
    ways[b].append((a, c))

print(dijkstra(1, n, k, ways))