import sys, collections

input = lambda: sys.stdin.readline().rstrip()


def dfs(start, visited):
    if start in visited:
        return

    print(start, end=" ")
    visited.add(start)
    for g in graph[start]:
        if g not in visited:
            dfs(g, visited)


def bfs(start):
    q = collections.deque([start])
    visited = set([start])

    while q:
        x = q.popleft()
        print(x, end=" ")

        for g in graph[x]:
            if g not in visited:
                visited.add(g)
                q.append(g)


N, M, V = map(int, input().split())

graph = collections.defaultdict(lambda: [])

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, N + 1):
    graph[i].sort()

dfs(V, set())
print()
bfs(V)
