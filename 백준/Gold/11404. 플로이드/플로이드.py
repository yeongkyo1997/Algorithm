import sys


def input(): return sys.stdin.readline().rstrip()


n = int(input())
m = int(input())

graph = [[float('inf')] * (n + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    graph[i][i] = 0


for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a][b] = min(graph[a][b], c)

for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

for i in range(1, n + 1):
    print(*[j if j != float('inf') else 0 for j in graph[i][1:]])