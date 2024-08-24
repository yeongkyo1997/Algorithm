import collections

N = int(input())

point = []

for _ in range(N):
    x, y = map(float, input().split())
    point.append((x, y))

graph = []


def get_dist(p1, p2):
    return ((p1[0] - p2[0]) ** 2 + (p1[1] - p2[1]) ** 2) ** 0.5


for i in range(N):
    for j in range(N):
        if i == j:
            continue
        graph.append((i, j, get_dist(point[i], point[j])))

graph.sort(key=lambda x: x[-1])

parent = [i for i in range(N + 1)]
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
    elif rank[a] < rank[b]:
        parent[a] = b
    else:
        parent[b] = a
        rank[a] += 1
    return True


result = 0

for s, e, d in graph:
    if union(s, e):
        result += d

print(result)
