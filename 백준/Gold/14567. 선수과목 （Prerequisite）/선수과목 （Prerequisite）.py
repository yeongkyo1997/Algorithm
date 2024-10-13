import collections
import sys

input = lambda: sys.stdin.readline().rstrip()

if __name__ == '__main__':
    N, M = map(int, input().split())

    in_degree = collections.defaultdict(int)
    graph = collections.defaultdict(list)
    cost = collections.defaultdict(lambda: 1)
    for _ in range(M):
        a, b = map(int, input().split())
        in_degree[b] += 1
        graph[a].append(b)

    q = collections.deque([i for i in range(1, N + 1) if in_degree[i] == 0])

    while q:
        x = q.popleft()
        for g in graph[x]:
            in_degree[g] -= 1
            cost[g] = cost[x] + 1
            if in_degree[g] == 0:
                q.append(g)

    print(*[cost[i] for i in range(1, N + 1)])