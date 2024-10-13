import collections

if __name__ == '__main__':
    N, M = map(int, input().split())
    graph = collections.defaultdict(list)
    in_degree = [0] * (N + 1)
    for _ in range(M):
        num, *data = map(int, input().split())
        for i in range(len(data) - 1):
            graph[data[i]].append(data[i + 1])
            in_degree[data[i + 1]] += 1

    q = collections.deque([i for i in range(1, N + 1) if in_degree[i] == 0])

    result = []
    while q:
        x = q.popleft()
        result.append(x)

        for g in graph[x]:
            in_degree[g] -= 1
            if in_degree[g] == 0:
                q.append(g)
    if len(result) != N:
        print(0)
    else:
        print('\n'.join(map(str, result)))