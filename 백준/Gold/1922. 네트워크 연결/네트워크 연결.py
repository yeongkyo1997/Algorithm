import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())
M = int(input())

graph = [list(map(int, input().split())) for _ in range(M)]
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

    if a > b:
        parent[a] = b
    else:
        parent[b] = a

    return True


graph.sort(key=lambda x: x[2])
result = 0
for a, b, c in graph:
    if union(a, b):
        result += c

print(result)