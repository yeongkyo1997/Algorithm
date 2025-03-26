import sys
from collections import defaultdict

input = lambda: sys.stdin.readline().rstrip()

n = int(input())
m = int(input())

dist = [[float("inf")] * (n + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    dist[i][i] = 0

for _ in range(m):
    a, b, c = map(int, input().split())
    dist[a][b] = min(dist[a][b], c)


for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            dist[i][j] = min(dist[i][k] + dist[k][j], dist[i][j])

for i in range(1, n + 1):
    for j in range(1, n + 1):
        print(dist[i][j] if dist[i][j] != float("inf") else 0, end=" ")
    print()
