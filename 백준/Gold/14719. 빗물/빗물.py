import sys

input = sys.stdin.readline

m, n = map(int, input().split())
v = list(map(int, input().split()))

result = 0

for i in range(1, n - 1):
    l = 0
    r = 0

    for j in range(0, i):
        if v[i] < v[j]:
            l = max(l, v[j])

    for j in range(i + 1, n):
        if v[i] < v[j]:
            r = max(r, v[j])

    if l and r:
        result += min(l, r) - v[i]

print(result)
