import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

V, E = map(int, input().split())
parent = [i for i in range(V + 1)]

edges = []

for _ in range(E):
    edges.append(list(map(int, input().split())))

edges.sort(key=lambda _: _[2])


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

    parent[max(a, b)] = min(a, b)

    return True


result = 0

for start, end, weight in edges:
    if union(start, end):
        result += weight

print(result)
