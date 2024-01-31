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


N, M = map(int, input().split())
board = [list(map(float, input().split())) for _ in range(N)]
parent = [i for i in range(N + 1)]
rank = [0] * (N + 1)

for _ in range(M):
    union(*map(lambda x: int(x) - 1, input().split()))

graph = []
for i in range(N):
    for j in range(i + 1, N):
        graph.append(
            (i, j, ((board[i][0] - board[j][0]) ** 2 + (board[i][1] - board[j][1]) ** 2) ** 0.5))


graph.sort(key=lambda x: x[2])

print(f'{sum(cost for a, b, cost in graph if union(a, b)):.2f}')