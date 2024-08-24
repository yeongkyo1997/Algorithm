import collections
import sys

input = lambda: sys.stdin.readline().rstrip()

V, E = map(int, input().split())

graph = []

for _ in range(E):
    s, e, d = map(int, input().split())
    graph.append((s, e, d))

parent = [i for i in range(V + 1)]
rank = collections.defaultdict(int)


def find(a):
    if a != parent[a]:
        parent[a] = find(parent[a])
    return parent[a]


def union(a, b):
    a = find(a)
    b = find(b)

    if a == b:
        return False

    if rank[a] > rank[b]:
        parent[b] = a
    elif rank[a] < rank[a]:
        parent[a] = b
    else:
        parent[b] = a
        rank[a] += 1

    return True


graph.sort(key=lambda x: x[2])

result = 0
for s, e, d in graph:
    if union(s, e):
        result += d

print(result)