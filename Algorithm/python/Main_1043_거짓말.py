import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def find(x):
    if parents[x] == x:
        return x
    parents[x] = find(parents[x])
    return parents[x]


def union(x, y):
    x = find(x)
    y = find(y)
    parents[x] = y


n, m = map(int, input().split())
k, *know = map(int, input().split())
parents = [i for i in range(n + 1)]
v = [[] for _ in range(m)]
for i in range(m):
    p, *party = map(int, input().split())
    for j in range(p - 1):
        union(party[j], party[j + 1])
    v[i] = party
for i in range(m):
    flag = False
    for person in v[i]:
        if flag:
            break
        for t in know:
            if find(person) == find(t):
                flag = True
                break
    if flag:
        m -= 1

print(m)
