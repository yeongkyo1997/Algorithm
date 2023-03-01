import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

V, E = map(int, input().split())
edges = []
parent = [i for i in range(V + 1)]


def find(a):
    if parent[a] == a:
        return a

    parent[a] = find(parent[a])
    return parent[a]


def union(a, b):
    aRoot = find(a)
    bRoot = find(b)

    if aRoot == bRoot:
        return False

    parent[aRoot] = bRoot
    return True


for _ in range(E):
    a, b, cost = map(int, input().split())
    edges.append((a, b, cost))

edges.sort(key=lambda x: x[2])
result = 0

for i in edges:
    a, b, cost = i
    if union(a, b):
        result += cost

print(result)
