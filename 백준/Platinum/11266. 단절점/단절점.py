import sys

sys.setrecursionlimit(100000)

input = lambda: sys.stdin.readline().rstrip()


def find_articulation_points(V, edges):
    graph = [[] for _ in range(V + 1)]
    for u, v in edges:
        graph[u].append(v)
        graph[v].append(u)

    visited = [False] * (V + 1)
    discovery = [0] * (V + 1)
    low = [0] * (V + 1)
    parent = [-1] * (V + 1)
    articulation_points = set()
    time = [0]

    def dfs(u):
        visited[u] = True
        discovery[u] = low[u] = time[0]
        time[0] += 1
        children = 0

        for v in graph[u]:
            if not visited[v]:
                parent[v] = u
                children += 1
                dfs(v)
                low[u] = min(low[u], low[v])

                if parent[u] == -1 and children > 1:
                    articulation_points.add(u)
                if parent[u] != -1 and low[v] >= discovery[u]:
                    articulation_points.add(u)
            elif v != parent[u]:
                low[u] = min(low[u], discovery[v])

    for i in range(1, V + 1):
        if not visited[i]:
            dfs(i)

    return sorted(articulation_points)


V, E = map(int, input().split())
edges = [list(map(int, input().split())) for _ in range(E)]
articulation_points = find_articulation_points(V, edges)
print(len(articulation_points))
print(' '.join(map(str, articulation_points)))