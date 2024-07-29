import collections
import copy

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

N, M = map(int, input().rstrip().split())

board = [list(map(int, input().rstrip().split())) for _ in range(N)]

one_cnt = 0
for b in board:
    one_cnt += b.count(1)


def bfs(board, x, y):
    q = collections.deque()
    visited = [[False] * M for _ in range(N)]
    visited[x][y] = True
    q.append((x, y))

    while q:
        x, y = q.popleft()
        if x == 0 or x == N - 1 or y == 0 or y == M - 1:
            return True

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]

            if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == 0 and not visited[nx][ny]:
                visited[nx][ny] = True
                q.append((nx, ny))

    return False


result = 0
cheese = 0
while one_cnt > 0:
    tmp = copy.deepcopy(board)
    for i in range(N):
        for j in range(M):
            if tmp[i][j] == 1 and bfs(tmp, i, j):
                board[i][j] = 0
                one_cnt -= 1
    result += 1
    if one_cnt == 0:
        print(result)
        for b in tmp:
            cheese += b.count(1)
        print(cheese)
        break