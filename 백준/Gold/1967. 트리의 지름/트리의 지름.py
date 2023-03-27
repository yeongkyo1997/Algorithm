import sys

sys.setrecursionlimit(100000)
input = sys.stdin.readline

N = int(input())
graph = [[] for _ in range(N + 1)]

for i in range(N - 1):
    arr, b, c = map(int, input().split())
    graph[arr].append((b, c))
    graph[b].append((arr, c))

distance = [-1] * (N + 1)
distance[1] = 0


def dfs(x, weight):
    for i in graph[x]:
        a, b = i
        if distance[a] == -1:
            distance[a] = weight + b
            dfs(a, weight + b)


dfs(1, 0)

start = distance.index(max(distance))
distance = [-1] * (N + 1)
distance[start] = 0
dfs(start, 0)
print(max(distance))
