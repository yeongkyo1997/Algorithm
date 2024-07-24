import collections

N, L, R = map(int, input().rstrip().split())

board = [list(map(int, input().rstrip().split())) for _ in range(N)]

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]


def is_union(x, y, nx, ny):
    return L <= abs(board[nx][ny] - board[x][y]) <= R


def bfs(x, y):
    global visited
    q = collections.deque()
    q.append((x, y))
    visited.add((x, y))
    union = [(x, y)]
    while q:
        x, y = q.popleft()

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]

            if nx < 0 or ny < 0 or nx >= N or ny >= N:
                continue

            if is_union(x, y, nx, ny) and (nx, ny) not in visited:
                visited.add((nx, ny))
                union.append((nx, ny))
                q.append((nx, ny))

    if len(union) <= 1:
        return False

    ret = sum(board[x][y] for x, y in union) // len(union)

    for x, y in union:
        board[x][y] = ret

    return True


result = 0
while True:
    flag = False
    visited = set()
    for i in range(N):
        for j in range(N):
            if (i, j) not in visited:
                if bfs(i, j):
                    flag = True
    if not flag:
        break
    result += 1

print(result)