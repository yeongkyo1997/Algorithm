import sys
from collections import deque


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())

graph = []
visited = []

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

for i in range(N):
    graph.append(list(input()))
rx, ry, bx, by = [0] * 4

for i in range(N):
    for j in range(M):
        if graph[i][j] == 'R':
            rx, ry = i, j
        if graph[i][j] == 'B':
            bx, by = i, j


def move(x, y, dx, dy):
    cnt = 0
    while graph[x + dx][y + dy] != '#' and graph[x][y] != 'O':
        x += dx
        y += dy
        cnt += 1
    return x, y, cnt


q = deque()
q.append((rx, ry, bx, by, 1))
visited.append((rx, ry, bx, by))

while q:
    rx, ry, bx, by, result = q.popleft()

    if result > 10:
        break

    for i in range(4):
        nrx, nry, rcnt = move(rx, ry, dx[i], dy[i])
        nbx, nby, bcnt = move(bx, by, dx[i], dy[i])

        if graph[nbx][nby] == 'O':
            continue

        if graph[nrx][nry] == 'O':
            print(result)
            exit(0)

        if nrx == nbx and nry == nby:
            if rcnt > bcnt:
                nrx -= dx[i]
                nry -= dy[i]
            else:
                nbx -= dx[i]
                nby -= dy[i]

        if (nrx, nry, nbx, nby) not in visited:
            visited.append((nrx, nry, nbx, nby))
            q.append((nrx, nry, nbx, nby, result + 1))
print(-1)