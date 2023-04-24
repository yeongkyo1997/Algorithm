import heapq
import sys

input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())

graph = [[] for _ in range(N + 1)]
indegree = [0] * (N + 1)

for i in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    indegree[b] += 1

heap = []
for i in range(1, N + 1):
    if indegree[i] == 0:
        heap.append(i)

while heap:
    cur = heapq.heappop(heap)
    print(cur, end=' ')
    for i in graph[cur]:
        indegree[i] -= 1
        if indegree[i] == 0:
            heapq.heappush(heap, i)
