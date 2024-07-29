import collections
import copy

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

N, M = map(int, input().rstrip().split())
board = [list(map(int, input().rstrip().split())) for _ in range(N)]


def bfs(board, x, y):
    visited = [[False] * M for _ in range(N)]
    q = collections.deque()
    visited[x][y] = True
    q.append((x, y))

    while q:
        x, y = q.popleft()
        if x == 0 or x == N - 1 or y == 0 or y == M - 1 or reach[x][y]:
            return True

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == 0 and not visited[nx][ny]:
                visited[nx][ny] = True
                q.append((nx, ny))
    return False


one_cnt = 0
for b in board:
    one_cnt += b.count(1)

result = 0

while one_cnt > 0:
    tmp = copy.deepcopy(board)
    reach = [[False] * M for _ in range(N)]
    for i in range(N):
        for j in range(M):
            if tmp[i][j] == 1:
                cnt = 0
                for d in range(4):
                    x, y = i + dx[d], j + dy[d]
                    if x < 0 or x >= N or y < 0 or y >= M:
                        continue
                    if tmp[x][y] == 1:
                        continue
                    if tmp[x][y] == 0 and bfs(tmp, x, y):
                        cnt += 1
                        reach[x][y] = True
                if cnt >= 2:
                    board[i][j] = 0
                    one_cnt -= 1
    result += 1

print(result)