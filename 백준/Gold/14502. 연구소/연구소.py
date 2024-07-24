import collections
import copy

N, M = map(int, input().rstrip().split())

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
board = [list(map(int, input().rstrip().split())) for _ in range(N)]
virus = []
zero = []
for i in range(N):
    for j in range(M):
        if board[i][j] == 2:
            virus.append((i, j))
        if board[i][j] == 0:
            zero.append((i, j))


def cnt_zero(board):
    cnt = 0
    for b in board:
        cnt += b.count(0)

    return cnt


def dfs(path, start, depth):
    global result
    if depth == 3:
        tmp = copy.deepcopy(board)
        for p in path:
            x, y = zero[p]
            tmp[x][y] = 2

        result = max(result, bfs(tmp))
        return

    for i in range(start, len(zero)):
        path.append(i)
        dfs(path, i + 1, depth + 1)
        path.pop()


def bfs(board):
    q = collections.deque()
    for v in virus:
        q.append(v)

    while q:
        x, y = q.popleft()

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]

            if nx < 0 or ny < 0 or nx >= N or ny >= M:
                continue
            if board[nx][ny] == 0:
                board[nx][ny] = 2
                q.append((nx, ny))

    return cnt_zero(board)


result = 0
dfs([], 0, 0)
print(result)