import collections
import sys

input = lambda: sys.stdin.readline().rstrip()
if __name__ == '__main__':
    N, M = map(int, input().split())

    # 진입 차수를 저장
    in_degree = [0] * (N + 1)
    # 그래프 저장
    graph = [[] for _ in range(N + 1)]

    for _ in range(M):
        a, b = map(int, input().split())
        graph[a].append(b)
        in_degree[b] += 1

    q = collections.deque()
    for i in range(1, N + 1):
        if in_degree[i] == 0:
            q.append(i)

    result = []

    while q:
        node = q.popleft()
        result.append(node)

        for g in graph[node]:
            in_degree[g] -= 1
            if in_degree[g] == 0:
                q.append(g)

    print(*result)