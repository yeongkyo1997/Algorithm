table = [[''] * 50 for _ in range(50)]
parent = [[i for i in range(50)] for _ in range(50)]


def find(a):
    if parent[a] == a:
        return parent[a]

    parent[a] = find(parent[a])
    return parent[a]


def union(a, b):
    a, b = find(a), find(b)

    if a == b:
        return False

    parent[max(a, b)] = min(a, b)
    return True


def update1(r, c, value):
    x = parent[r * 50 + c]
    rootx = find(x)

    table[rootx] = value


def update2(value1, value2):
    for i in range(50 ** 2):
        if table[i] == value1:
            table[i] = value2


def merge(r1, c1, r2, c2):
    x1, x2 = parent[r1 * 50 + c1], parent[r2 * 50 + c2]
    rootx1, rootx2 = find(x1), find(x2)

    if not table[rootx1] and table[rootx2]:
        table[rootx2] = table[rootx1]
    else:
        table[rootx1] = table[rootx2]


def unmerge(r, c):
    x = r * 50 + c
    rootx = find(x)
    value = table[rootx]

    for i in range(50 ** 2):
        if i == rootx:
            parent[i] = i

    table[rootx] = value


def pr(r, c):
    x = r * 50 + c
    rootx = find(x)

    print(table[rootx])
