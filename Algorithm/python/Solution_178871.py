parent = [i for i in range(50 * 50)]
cell = [""] * (50 * 50)
result = []


def find(a):
    if parent[a] == a:
        return a

    parent[a] = find(parent[a])
    return parent[a]


def union(a, b):
    a = find(a)
    b = find(b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b


def update(r, c, value):
    idx = (r - 1) * 50 + c - 1
    rootIdx = find(idx)
    cell[rootIdx] = value


def merge(r1, c1, r2, c2):
    idx1 = (r1 - 1) * 50 + c1 - 1
    idx2 = (r2 - 1) * 50 + c2 - 1

    rootIdx1 = find(idx1)
    rootIdx2 = find(idx2)

    union(rootIdx1, rootIdx2)


def unmerge(r, c):
    idx = (r - 1) * 50 + c - 1
    rootIdx = find(idx)

    parent[rootIdx] = rootIdx


def print(r, c):
    idx = (r - 1) * 50 + c - 1
    rootIdx = find(idx)

    result.append(cell[rootIdx])


def solution(commands):
    for command in commands:
        if command[0] == 'UPDATE':
            if len(command) == 4:
                r, c, value = command[1:]
                update(r, c, value)
            else:
                val1, val2 = command[1:]
                for i in range(len(cell)):
                    if cell[i] == val1:
                        cell[i] = val2
        elif command[0] == 'MERGE':
            r1, c1, r2, c2 = command[1:]
            merge(r1, c1, r2, c2)
        elif command[0] == 'UNMERGE':
            r, c = command[1:]
            unmerge(r, c)
        elif command[0] == 'PRINT':
            r, c = command[1:]
            print(r, c)

    return result
