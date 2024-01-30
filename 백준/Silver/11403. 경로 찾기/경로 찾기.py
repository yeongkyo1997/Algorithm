import sys


def input(): return sys.stdin.readline()


N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]

for k in range(N):
    for i in range(N):
        for j in range(N):
            graph[i][j] = graph[i][j] or (graph[i][k] and graph[k][j])
            graph[i][j] = int(graph[i][j])


for i in graph:
    print(*i)