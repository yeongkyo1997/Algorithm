import heapq
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

n, m, k = map(int, input().split())
g = [[] for _ in range(n + 1)]
heap = [[] for _ in range(n + 1)]


def kth_dijkstra():
    pq = [(0, 1)]
    heapq.heapify(pq)
    heap[1].append(0)
    while pq:
        cost, now = heapq.heappop(pq)
        for nxt, nxtCost in g[now]:
            nxtCost += cost
            if len(heap[nxt]) < k:
                heapq.heappush(heap[nxt], -nxtCost)
                heapq.heappush(pq, (nxtCost, nxt))
            elif -heap[nxt][0] > nxtCost:
                heapq.heappop(heap[nxt])
                heapq.heappush(heap[nxt], -nxtCost)
                heapq.heappush(pq, (nxtCost, nxt))


for _ in range(m):
    a, b, c = map(int, input().split())
    g[a].append((b, c))
kth_dijkstra()

for i in range(1, n + 1):
    if len(heap[i]) != k:
        print(-1)
    else:
        print(-heap[i][0])