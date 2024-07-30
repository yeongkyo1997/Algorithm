import collections

N, M, K = map(int, input().rstrip().split())
center = set(map(int, input().rstrip().split()))


def find(x):
    if parent[x] == x:
        return parent[x]
    parent[x] = find(parent[x])
    return parent[x]


def union(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return False

    if rank[a] > rank[b]:
        parent[b] = a
    elif rank[a] < rank[b]:
        parent[a] = b
    else:
        rank[a] += 1
        parent[b] = a

    return True


parent = [0] * (N + 1)
rank = collections.defaultdict(lambda: 0)
for i in range(1, N + 1):
    if i in center:
        continue
    parent[i] = i

edges = []
for _ in range(M):
    u, v, w = map(int, input().rstrip().split())
    edges.append((u, v, w))

edges.sort(key=lambda x: x[-1])

result = 0
for a, b, cost in edges:
    if union(a, b):
        result += cost

print(result)