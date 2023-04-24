import collections
import math
import sys

input = lambda: sys.stdin.readline().rstrip()

N = int(input())
M = int(input())
parent = [i for i in range(N + 1)]
dist = collections.defaultdict(lambda: math.inf)
graph = collections.defaultdict(lambda: ())


def find(a):
    if parent[a] == a:
        return a
    parent[a] = find(parent[a])

    return parent[a]


def union(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return False

    parent[max(a, b)] = min(a, b)
    return True


result = 0

for i in range(M):
    a, b, c = map(int, input().split())
    graph[a][b] = c

for i in range(1, N + 1):
    for j in graph[i]:
        dist[(i, j)] = graph[i][j]

graph = sorted(dist.items(), key=lambda x: x[1])

for i in graph:
    if union(i[0][0], i[0][1]):
        result += i[1]

print(result)
