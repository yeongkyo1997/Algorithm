import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()


def bfs(start, h, w, grid):
    INF = h * w + 10
    dist = [[INF] * (w + 2) for _ in range(h + 2)]
    q = deque()
    sy, sx = start
    dist[sy][sx] = 0
    q.append((sy, sx))
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    while q:
        y, x = q.popleft()
        for dy, dx in directions:
            ny, nx = y + dy, x + dx
            if 0 <= ny < h + 2 and 0 <= nx < w + 2:
                if grid[ny][nx] == '*':
                    continue
                cost = dist[y][x]
                if grid[ny][nx] == '#':
                    cost += 1
                if dist[ny][nx] > cost:
                    dist[ny][nx] = cost
                    if grid[ny][nx] == '#':
                        q.append((ny, nx))
                    else:
                        q.appendleft((ny, nx))
    return dist


T = int(input())
for _ in range(T):
    h, w = map(int, input().split())
    original_grid = [input() for _ in range(h)]
    grid = [['.'] * (w + 2) for _ in range(h + 2)]
    prisoners = []
    for i in range(h):
        for j in range(w):
            grid[i + 1][j + 1] = original_grid[i][j]
            if original_grid[i][j] == '$':
                prisoners.append((i + 1, j + 1))
    start1 = (0, 0)
    start2, start3 = prisoners
    dist0 = bfs(start1, h, w, grid)
    dist1 = bfs(start2, h, w, grid)
    dist2 = bfs(start3, h, w, grid)
    min_doors = float('inf')
    for i in range(h + 2):
        for j in range(w + 2):
            if grid[i][j] == '*':
                continue
            total = dist0[i][j] + dist1[i][j] + dist2[i][j]
            if grid[i][j] == '#':
                total -= 2
            if total < min_doors:
                min_doors = total
    print(min_doors)