import sys


def input(): return sys.stdin.readline().rstrip()


V, E = map(int, input().split())
graph = []

for _ in range(E):
    a, b, c = map(int, input().split())
    graph.append((a, b, c))

graph.sort(key=lambda x: x[2])

parent = [i for i in range(V + 1)]


def find(x):
    if x == parent[x]:
        return x

    parent[x] = find(parent[x])

    return parent[x]


def union(a, b):
    a = find(parent[a])
    b = find(parent[b])

    if a == b:
        return False

    if a > b:
        parent[a] = b
    else:
        parent[b] = a

    return True


result = 0
for a, b, c in graph:
    if union(a, b):
        result += c

print(result)