import sys


def input(): return sys.stdin.readline().rstrip()


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

    if rank[a] > rank[b]:
        parent[b] = a
    elif rank[a] < rank[b]:
        parent[a] = b
    else:
        parent[a] = b
        rank[b] += 1

    return True


N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]
graph = []

for i in range(N):
    for j in range(N):
        if i == j:
            continue
        graph.append((i, j, board[i][j]))

parent = [i for i in range(N + 1)]
rank = [0] * (N + 1)

graph.sort(key=lambda x: x[2])

result = 0

for a, b, c in graph:
    if union(a, b):
        result += c

print(result)