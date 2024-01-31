import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

graph = []

for i in range(N):
    for j in range(N):
        if i == j:
            continue
        graph.append((i, j, board[i][j]))

parent = [i for i in range(N + 1)]
graph = sorted(graph, key=lambda x: x[2])


def find(a):
    if parent[a] == a:
        return a

    parent[a] = find(parent[a])
    return parent[a]


def union(a, b):
    a = find(parent[a])
    b = find(parent[b])

    if a == b:
        return False

    parent[a] = b

    return True


result = 0
for a, b, c in graph:
    if union(a, b):
        result += c

print(result)