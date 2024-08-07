import collections
import copy
import math

dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]
N, M = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]

virus = []
zero_cnt = -3
for i in range(N):
    for j in range(M):
        if board[i][j] == 2:
            virus.append((i, j))
        if board[i][j] == 0:
            zero_cnt += 1


def bfs(board, zero_cnt):
    global result
    q = collections.deque(virus)
    while q:
        x, y = q.popleft()
        for dx, dy in dir:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == 0:
                board[nx][ny] = 2
                q.append((nx, ny))
                zero_cnt -= 1
    result = max(result, zero_cnt)


def dfs(path, depth, sx, sy):
    if depth == 3:
        tmp = copy.deepcopy(board)
        for x, y in path:
            tmp[x][y] = 1
        bfs(tmp, zero_cnt)
        return

    for i in range(sx, N):
        for j in range(sy, M):
            if board[i][j] != 0:
                continue
            path.append((i, j))
            if j == M - 1:
                dfs(path, depth + 1, i + 1, 0)
            else:
                dfs(path, depth + 1, i, j + 1)

            path.pop()
        sy = 0


result = -math.inf
dfs([], 0, 0, 0)
print(result)