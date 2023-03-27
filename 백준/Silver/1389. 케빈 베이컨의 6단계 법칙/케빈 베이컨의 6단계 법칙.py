import sys
from collections import deque


def bfs(graph, start):
    num = [0] * (N + 1)
    visited = [start]
    queue = deque()
    queue.append(start)

    while queue:
        a = queue.popleft()
        for i in graph[a]:
            if i not in visited:
                num[i] = num[a] + 1
                visited.append(i)
                queue.append(i)
    return sum(num)


if __name__ == '__main__':
    N, M = map(int, sys.stdin.readline().split())
    graph = [[] for _ in range(N + 1)]
    for i in range(M):
        arr, b = map(int, sys.stdin.readline().split())
        graph[arr].append(b)
        graph[b].append(arr)

    result = []
    for i in range(1, N + 1):
        result.append(bfs(graph, i))

    print(result.index(min(result)) + 1)
