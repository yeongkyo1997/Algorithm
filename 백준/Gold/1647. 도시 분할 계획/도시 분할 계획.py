import sys


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(M)]
graph.sort(key=lambda x: x[2])

parent = [i for i in range(N + 1)]


def find(a):
    if a == parent[a]:
        return a

    parent[a] = find(parent[a])

    return parent[a]


def union(a, b):
    a = find(parent[a])
    b = find(parent[b])

    if a == b:
        return False

    parent[max(a, b)] = min(a, b)
    return True


result = 0
last = 0
for a, b, c in graph:
    if union(a, b):
        result += c
        last = c

print(result - last)