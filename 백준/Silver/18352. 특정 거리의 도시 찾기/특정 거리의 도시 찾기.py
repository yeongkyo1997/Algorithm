import sys
from collections import deque
input = sys.stdin.readline
N, M, K, X = map(int, input().split())
graph = [[] for _ in range(N+1)]
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
dist = [-1]*(N+1)
dist[X] = 0
q = deque([X])
while q:
    cur = q.popleft()
    for nxt in graph[cur]:
        if dist[nxt] == -1:
            dist[nxt] = dist[cur] + 1
            q.append(nxt)
found = False
for i in range(1, N+1):
    if dist[i] == K:
        print(i)
        found = True
if not found:
    print(-1)
