import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

n, m, r = map(int, input().split())
graph = [[] for _ in range(n + 1)]
visited = [0] * (n + 1)
cnt = 1

for i in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)


def dfs(v):
    global cnt
    visited[v] = cnt
    graph[v].sort()

    for i in graph[v]:
        if visited[i] == 0:
            cnt += 1
            dfs(i)


dfs(r)

for i in visited[1:]:
    print(i)
