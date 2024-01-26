from itertools import combinations
N, M = map(int, input().split())

graph = [(0, 0)]

for _ in range(N):
    x, y = map(int, input().split())
    graph.append((x, y))

connected = set()

for _ in range(M):
    x, y = map(int, input().split())
    connected.add((x, y))
    connected.add((y, x))


def find(x):
    global parent
    if x == parent[x]:
        return x

    parent[x] = find(parent[x])

    return parent[x]


def union(a, b):
    global parent
    a = find(parent[a])
    b = find(parent[b])

    if a == b:
        return False

    if a > b:
        parent[a] = b
    else:
        parent[b] = a

    return True


def get_distance(p1, p2):
    return ((p1[0] - p2[0]) ** 2 + (p1[1] - p2[1]) ** 2) ** 0.5


distance = []
parent = [i for i in range(N + 1)]
result = 0
for i, j in combinations(range(1, N + 1), 2):
    dist = get_distance(graph[i], graph[j])
    distance.append((i, j, dist))
    if (i, j) in connected:
        union(i, j)


distance.sort(key=lambda x: x[2])

for a, b, c in distance:
    if union(a, b):
        result += c

print(f'{round(result, 2):.2f}')