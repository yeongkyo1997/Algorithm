import sys

input = lambda: sys.stdin.readline().rstrip()


def bfs():
    cnt = 0
    while q:
        size = len(q)
        cnt += 1
        for _ in range(size):
            r, c, h = q.pop(0)
            for i in range(6):
                nr = r + dir[i][0]
                nc = c + dir[i][1]
                nh = h + dir[i][2]
                if 0 <= nr < R and 0 <= nc < C and 0 <= nh < H:
                    if graph[nh][nr][nc] == 0:
                        q.append((nr, nc, nh))
                        graph[nh][nr][nc] = 1

    for i in range(H):
        for j in range(R):
            for k in range(C):
                if graph[i][j][k] == 0:
                    print(-1)
                    return

    print(cnt - 1)


C, R, H = map(int, input().split())

graph = []

for _ in range(H):
    graph.append([list(map(int, input().split())) for _ in range(R)])

dir = [
    [1, 0, 0],
    [0, 1, 0],
    [-1, 0, 0],
    [0, -1, 0],
    [0, 0, 1],
    [0, 0, -1],
]
q = []
for i in range(H):
    for j in range(R):
        for k in range(C):
            if graph[i][j][k] == 1:
                q.append((j, k, i))
bfs()
