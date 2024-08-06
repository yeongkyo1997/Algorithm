import collections

N, M, V = map(int, input().rstrip().split())

graph = collections.defaultdict(list)

for _ in range(M):
    a, b = map(int, input().rstrip().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, N + 1):
    graph[i].sort()


def dfs(n):
    global flag
    if flag & (1 << n):
        return
    flag |= 1 << n
    print(n, end=' ')

    for g in graph[n]:
        dfs(g)


def bfs(n):
    flag = 0
    q = collections.deque()
    q.append(n)
    flag |= 1 << n
    print(n, end=' ')
    while q:
        n = q.popleft()
        for g in graph[n]:
            if flag & (1 << g) == 0:
                q.append(g)
                print(g, end=' ')
                flag |= 1 << g


flag = 0
dfs(V)
print()
bfs(V)