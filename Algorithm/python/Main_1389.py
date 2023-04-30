import math
import sys

input = lambda: sys.stdin.readline().rstrip()


def floyd():
    for k in range(1, N + 1):
        for i in range(1, N + 1):
            if i == k:
                continue
            for j in range(1, N + 1):
                if j == k:
                    continue
                elif graph[i][k] != 0 and graph[k][j] != 0:
                    if graph[i][j] == 0:
                        graph[i][j] = graph[i][k] + graph[k][j]
                    else:
                        graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])


N, M = map(int, input().split())
graph = [[0] * (N + 1) for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a][b] = graph[b][a] = 1

floyd()

result = math.inf
person = 0

for i in range(1, N + 1):
    SUM = 0
    for j in range(1, N + 1):
        SUM += graph[i][j]

    if result > SUM:
        result = SUM
        person = i

print(person)
