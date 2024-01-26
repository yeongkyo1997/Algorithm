import sys

sys.setrecursionlimit(10 ** 5)


def input(): return sys.stdin.readline().rstrip()


n = int(input())


graph = []


def get_distance(a, b):
    return ((a[0] - b[0])** 2 + (a[1] - b[1]) ** 2) ** 0.5


point = []
for i in range(n):
    a, b = map(float, input().split())
    point.append((a, b))


def find(x):
    global parent
    if parent[x] == x:
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


distance = []
for i in range(n):
    for j in range(i + 1, n):
        distance.append((i, j, get_distance(point[i], point[j])))

distance.sort(key=lambda x: x[2])
parent = [i for i in range(len(distance))]

result = 0
for a, b, c in distance:
    if union(a, b):
        result += c

print(result)