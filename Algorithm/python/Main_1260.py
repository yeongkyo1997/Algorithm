import collections
import sys

input = lambda: sys.stdin.readline().rstrip()

N, M, V = map(int, input().split())
graph = collections.defaultdict(list)
visited = collections.defaultdict(lambda: False)

for i in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


def dfs(v):
    visited[v] = True
    print(v, end=' ')
    for i in sorted(graph[v]):
        if not visited[i]:
            dfs(i)


def bfs(v):
    q = collections.deque()
    visited = collections.defaultdict(lambda: False)
    q.append((v))
    print(v, end=' ')
    visited[v] = True

    while q:
        cur = q.popleft()
        for i in sorted(graph[cur]):
            if not visited[i]:
                visited[i] = True
                print(i, end=' ')
                q.append(i)


dfs(V)
print()
bfs(V)
