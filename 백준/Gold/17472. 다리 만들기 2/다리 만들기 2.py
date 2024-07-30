import collections

N, M = map(int, input().rstrip().split())
board = [list(map(int, input().rstrip().split())) for _ in range(N)]
dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def bfs(x, y, mark):
    q = collections.deque([(x, y)])
    visited[x][y] = True
    board[x][y] = mark

    while q:
        x, y = q.popleft()

        for dx, dy in dir:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny] and board[nx][ny] == 1:
                visited[nx][ny] = True
                board[nx][ny] = mark
                q.append((nx, ny))


def get_dist(x, y, num, dx, dy):
    nx, ny = x, y
    dist = 0

    while True:
        nx += dx
        ny += dy
        if nx < 0 or nx >= N or ny < 0 or ny >= M or board[nx][ny] == num:
            break
        if board[nx][ny] != 0 and board[nx][ny] != num:
            return nx, ny, dist
        dist += 1
    return -1, -1, -1


def find(x):
    if parent[x] == x:
        return x
    parent[x] = find(parent[x])
    return parent[x]


def union(a, b):
    a = find(a)
    b = find(b)

    if a != b:
        if rank[a] > rank[b]:
            parent[b] = a
        elif rank[a] > rank[b]:
            parent[a] = b
        else:
            parent[b] = a
            rank[a] += 1


mark = 1
visited = [[False] * M for _ in range(N)]
for i in range(N):
    for j in range(M):
        if board[i][j] == 1 and not visited[i][j]:
            bfs(i, j, mark)
            mark += 1

edges = []
visited = [[False] * M for _ in range(N)]
for i in range(N):
    for j in range(M):
        if board[i][j] != 0:
            for dx, dy in dir:
                x, y, dist = get_dist(i, j, board[i][j], dx, dy)
                if x != -1 and dist >= 2:
                    edges.append((i, j, x, y, dist))

parent = [i for i in range((mark - 1))]
rank = [1] * (mark - 1)
mst = 0
edges.sort(key=lambda x: (x[-1]))

result = 0
for e in edges:
    a, b, c, d, cost = e
    if find(board[a][b] - 1) != find(board[c][d] - 1):
        result += cost
        mst += 1
        union(board[a][b] - 1, board[c][d] - 1)
        if mst == mark - 2:
            break

if mst != mark - 2:
    print(-1)
else:
    print(result)