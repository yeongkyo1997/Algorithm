import itertools, collections, math, sys

input = lambda: sys.stdin.readline().rstrip()


def get_dist(r1, c1, r2, c2):
    return abs(r1 - r2) + abs(c1 - c2)


N, M = map(int, input().split())


board = [list(map(int, input().split())) for _ in range(N)]

chicken = []
home = []

for i in range(N):
    for j in range(N):
        if board[i][j] == 1:
            home.append((i, j))
        if board[i][j] == 2:
            chicken.append((i, j))

result = float("inf")
for cxy in itertools.combinations(chicken, M):
    total = 0
    for hx, hy in home:
        dist = float("inf")
        for cx, cy in cxy:
            dist = min(dist, get_dist(hx, hy, cx, cy))
        total += dist

    result = min(total, result)

print(result)
