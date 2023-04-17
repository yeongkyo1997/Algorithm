import collections
import heapq
import math
import sys

input = lambda: sys.stdin.readline().rstrip()

n, m, k, x = map(int, input().split())
graph = collections.defaultdict(list)
dist = collections.defaultdict(lambda: math.inf)
visited = [False] * (n + 1)

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append((b, 1))



def dijkstra():
    dist[x] = 0
    heap = []
    heapq.heappush(heap, (0, x))

    while heap:
        cur = heapq.heappop(heap)

        for ele in graph[cur[1]]:
            if dist[ele[0]] > dist[cur[1]] + ele[1]:
                dist[ele[0]] = dist[cur[1]] + ele[1]
                heapq.heappush(heap, (dist[ele[0]], ele[0]))


dijkstra()

answer = []
for i in range(1, n + 1):
    if dist[i] == k:
        answer.append(i)

if answer:
    answer.sort()
    for i in answer:
        print(i)
else:
    print(-1)
