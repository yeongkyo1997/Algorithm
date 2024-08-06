import collections

N = int(input())

graph = collections.defaultdict(list)
for _ in range(int(input())):
    a, b = map(int, input().rstrip().split())
    graph[a].append(b)
    graph[b].append(a)

visited = set()


def dfs(n):
    if n in visited:
        return
    visited.add(n)

    for g in graph[n]:
        dfs(g)


dfs(1)

print(len(visited) - 1)