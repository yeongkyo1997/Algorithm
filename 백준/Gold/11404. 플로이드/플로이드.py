import sys


def input(): return sys.stdin.readline().rstrip()


n = int(input())
m = int(input())

graph = [[float('inf')] * (n + 1) for _ in range(n + 1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a][b] = min(graph[a][b], c)

for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if i == j:
                graph[i][j] = 0
                continue
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])


for i in graph[1:]:
    print(*[j if j != float('inf') else 0 for j in i[1:]])