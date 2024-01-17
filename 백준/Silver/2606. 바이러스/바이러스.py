import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())
M = int(input())

graph = {i: [] for i in range(1, N + 1)}

for i in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (N + 1)


def dfs(n):
    if visited[n]:
        return

    visited[n] = True
    for i in graph[n]:
        if visited[i]:
            continue
        dfs(i)


dfs(1)
print(visited.count(True) - 1)