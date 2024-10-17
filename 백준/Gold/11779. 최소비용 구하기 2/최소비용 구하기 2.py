import collections
import heapq
import math


def dijkstra(start, end):
    heap = []
    heapq.heappush(heap, (0, start))
    dist[start] = 0
    prev[start] = start

    while heap:
        cost, x = heapq.heappop(heap)

        if dist[x] < cost:
            continue

        for nxt, weight in graph[x]:
            if dist[nxt] > weight + cost:
                dist[nxt] = weight + cost
                heapq.heappush(heap, (dist[nxt], nxt))
                prev[nxt] = x


    path = []
    cur = end
    while True:
        path.append(cur)
        if cur == start:
            break
        cur = prev[cur]

    path = path[::-1]
    print(dist[end])
    print(len(path))
    print(*path)


if __name__ == '__main__':
    N = int(input())
    M = int(input())
    dist = collections.defaultdict(lambda: math.inf)
    prev = collections.defaultdict(int)

    board = [[math.inf] * (N + 1) for _ in range(N + 1)]

    for _ in range(M):
        a, b, c = map(int, input().split())
        board[a][b] = min(board[a][b], c)

    graph = collections.defaultdict(list)

    for i in range(1, N + 1):
        for j in range(1, N + 1):
            graph[i].append((j, board[i][j]))

    start, end = map(int, input().split())
    dijkstra(start, end)