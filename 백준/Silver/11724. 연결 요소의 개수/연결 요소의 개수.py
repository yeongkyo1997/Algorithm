import sys


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())
parent = {i: i for i in range(1, N + 1)}


def find(x):
    if parent[x] == x:
        return parent[x]

    parent[x] = find(parent[x])

    return parent[x]


def union(a, b):
    a = find(parent[a])
    b = find(parent[b])
    if a == b:
        return

    if a > b:
        parent[a] = b
    else:
        parent[b] = a


for _ in range(M):
    a, b = map(int, input().split())
    union(a, b)

for i in range(1, N + 1):
    parent[i] = find(parent[i])

print(len(set(parent.values())))