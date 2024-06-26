import sys
from collections import deque

sys.setrecursionlimit(10000)
input = sys.stdin.readline

N, M, r = map(int, input().split())
visited = [0] * (N + 1)
graph = [[] for _ in range(N + 1)]
cnt = 1

for i in range(M):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)


def bfs(v):
    global cnt
    queue = deque([r])
    visited[r] = 1

    while queue:
        v = queue.popleft()
        graph[v].sort(reverse=True)

        for i in graph[v]:
            if not visited[i]:
                cnt += 1
                visited[i] = cnt
                queue.append(i)


bfs(r)

for i in visited[1:]:
    print(i)
