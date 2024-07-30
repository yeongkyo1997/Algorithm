import collections

T = int(input())


def dfs(x):
    if x in visited:
        return 0
    visited.add(x)
    result = 1

    for i in graph[x]:
        result += dfs(i)

    return result


for _ in range(T):
    N, M = map(int, input().rstrip().split())
    graph = collections.defaultdict(lambda: [])

    for _ in range(M):
        a, b = map(int, input().rstrip().split())
        graph[a].append(b)
        graph[b].append(a)

    visited = set()

    print(dfs(1) - 1)