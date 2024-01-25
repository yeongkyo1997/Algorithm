import sys

sys.setrecursionlimit(10 ** 5)
def input(): return sys.stdin.readline().rstrip()


n, m = map(int, input().split())
parent = [i for i in range(n + 1)]


def find(x):
    if x == parent[x]:
        return x

    parent[x] = find(parent[x])

    return parent[x]


def union(a, b):
    a = find(parent[a])
    b = find(parent[b])

    if a > b:
        parent[a] = b
    else:
        parent[b] = a


for _ in range(m):
    c, a, b = map(int, input().split())
    if c == 0:
        union(a, b)
    elif c == 1:
        if find(parent[a]) == find(parent[b]):
            print('YES')
        else:
            print('NO')