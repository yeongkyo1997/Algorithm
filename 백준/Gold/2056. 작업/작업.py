import collections
import sys


if __name__ == '__main__':
    N = int(input())
    graph = collections.defaultdict(list)
    in_degree = collections.defaultdict(int)
    costs = collections.defaultdict(int)

    for i in range(1, N + 1):
        cost, cnt, *data = map(int, input().split())
        costs[i] = cost
        for d in data:
            graph[d].append(i)
            in_degree[i] += 1

    q = collections.deque(i for i in range(1, N + 1) if in_degree[i] == 0)

    total = 0
    acc = {i: costs[i] for i in range(1, N + 1)}
    while q:
        x = q.popleft()

        for g in graph[x]:
            in_degree[g] -= 1
            if in_degree[g] == 0:
                q.append(g)
            acc[g] = max(acc[x] + costs[g], acc[g])
    print(max(acc.values()))