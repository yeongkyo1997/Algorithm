import math

N, M = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]

chickens = []
homes = []

for i in range(N):
    for j in range(N):
        if board[i][j] == 1:
            homes.append((i, j))
        elif board[i][j] == 2:
            chickens.append((i, j))

result = math.inf


def dfs(path, depth, start):
    global result
    if depth == M:
        total = 0
        for hx, hy in homes:
            chicken_len = math.inf
            for cx, cy in path:
                chicken_len = min(chicken_len, abs(cx - hx) + abs(cy - hy))
            total += chicken_len
        result = min(result, total)
        return

    for i in range(start, len(chickens)):
        path.append(chickens[i])
        dfs(path, depth + 1, i + 1)
        path.pop()


dfs([], 0, 0)
print(result)