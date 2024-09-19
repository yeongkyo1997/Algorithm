import collections

def dfs(n, visited):
    if n in visited:
        return

    visited.add(n)
    print(n, end=' ')

    for g in graph[n]:
        if g not in visited:
            dfs(g, visited)


def bfs(n):
    q = collections.deque()
    visited = set()
    visited.add(n)
    q.append(n)

    while q:
        n = q.popleft()
        print(n, end=' ')
        for g in graph[n]:
            if g not in visited:
                visited.add(g)
                q.append(g)


if __name__ == '__main__':
    N, M, V = map(int, input().split())
    graph = collections.defaultdict(list)

    for _ in range(M):
        start, end = map(int, input().split())
        graph[start].append(end)
        graph[end].append(start)

    for key in graph.keys():
        graph[key].sort()

    dfs(V, set())
    print()
    bfs(V)