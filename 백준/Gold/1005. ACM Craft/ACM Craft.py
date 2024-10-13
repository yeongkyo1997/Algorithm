import collections
import sys

input = lambda: sys.stdin.readline().rstrip()

if __name__ == '__main__':
    for _ in range(int(input())):
        N, K = map(int, input().split())
        costs = [0] + list(map(int, input().split()))
        in_degree = [0] * (N + 1)
        graph = [[] for _ in range(N + 1)]

        for _ in range(K):
            a, b = map(int, input().split())
            graph[a].append(b)
            in_degree[b] += 1

        q = collections.deque([i for i in range(1, N + 1) if in_degree[i] == 0])
        result = costs[:]

        while q:
            x = q.popleft()

            for g in graph[x]:
                in_degree[g] -= 1
                result[g] = max(result[g], costs[g] + result[x])

                if in_degree[g] == 0:
                    q.append(g)

        W = int(input())
        print(result[W])