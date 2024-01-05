import sys
from collections import deque, defaultdict

sys.setrecursionlimit(10 ** 5)


def input(): return sys.stdin.readline().strip()


n, m, v = map(int, input().split())
lib = defaultdict(list)

for _ in range(m):
    a, b = map(int, input().split())
    lib[a].append(b)
    lib[b].append(a)

[lib[i].sort() for i in range(1, n + 1)]


def dfs(v):
    print(v, end=' ')
    visited[v] = True

    for i in lib[v]:
        if not visited[i]:
            dfs(i)


def bfs(v):
    q = deque()
    q.append(v)
    visited[v] = True

    while q:
        print(q[0], end=' ')
        for i in lib[q.popleft()]:
            if not visited[i]:
                visited[i] = True
                q.append(i)


visited = defaultdict(lambda: False)
dfs(v)
print()
visited = defaultdict(lambda: False)
bfs(v)