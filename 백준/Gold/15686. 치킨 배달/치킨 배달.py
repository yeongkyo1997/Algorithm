import sys
from itertools import combinations


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]


home = []
chicken = []
for i in range(N):
    for j in range(N):
        if board[i][j] == 1:
            home.append((i, j))
        elif board[i][j] == 2:
            chicken.append((i, j))


result = float('inf')
for i in combinations(chicken, M):
    dist = 0
    for a, b in home:
        dist += min(abs(a - x) + abs(b - y) for x, y in i)
    result = min(result, dist)

print(result)