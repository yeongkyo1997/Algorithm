import collections


def find(x):
    if x == parent[x]:
        return x
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
        parent[b] = a
        rank[a] += 1

    return True


for t in range(1, int(input()) + 1):
    V, E = map(int, input().split())

    graph = []

    for _ in range(E):
        a, b, c = map(int, input().split())
        graph.append((a, b, c))

    graph.sort(key=lambda x: x[-1])
    parent = collections.defaultdict(int)
    rank = collections.defaultdict(int)

    for i in range(1, V + 1):
        parent[i] = i

    result = 0
    for a, b, c in graph:
        if union(a, b):
            result += c

    print(f'#{t} {result}')
