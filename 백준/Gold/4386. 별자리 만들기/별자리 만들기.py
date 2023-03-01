import math
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N = int(input())
edges = []
parent = [i for i in range(N ** 2 + 1)]


def getDist(a, b):
    return math.sqrt(((a[0] - b[0]) ** 2) + ((a[1] - b[1]) ** 2))


def find(a):
    if a == parent[a]:
        return a

    parent[a] = find(parent[a])
    return parent[a]


def union(a, b):
    a = find(a)
    b = find(b)

    if a == b:
        return False

    parent[a] = b
    return True


for i in range(0, N):
    a, b = map(float, input().split())
    edges.append((a, b))

result = 0
node = []
for i in range(0, N):
    for j in range(i + 1, N):
        node.append((i, j, getDist(edges[i], edges[j])))

node.sort(key=lambda x: x[2])

for x, y, cost in node:
    if union(x, y):
        result += cost
print(result)
