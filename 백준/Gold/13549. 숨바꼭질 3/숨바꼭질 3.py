import sys
from heapq import heappush, heappop

input = sys.stdin.readline

INF = sys.maxsize
n, k = map(int, input().split())


def dijkstra(start, end):
    heap = []
    DP = [INF] * (10 ** 5 + 1)

    if end <= start:
        print(start - end)
        return
    heappush(heap, (0, start))
    DP[start] = 0

    while heap:
        w, n = heappop(heap)
        for nx in [n + 1, n - 1, n * 2]:
            if 0 <= nx <= 100000:
                if nx == n * 2 and DP[nx] == INF:
                    DP[nx] = w
                    heappush(heap, (w, nx))
                elif DP[nx] == INF:
                    DP[nx] = w + 1
                    heappush(heap, (w + 1, nx))
    print(DP[end])


dijkstra(n, k)
