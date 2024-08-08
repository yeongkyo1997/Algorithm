import collections

dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]

N, M = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]
one_cnt = 0
for b in board:
    one_cnt += b.count(1)


def bfs(x, y):
    global one_cnt
    q = collections.deque()
    q.append((x, y))
    visited = [[0] * M for _ in range(N)]
    visited[x][y] = 1

    while q:
        x, y = q.popleft()
        for dx, dy in dir:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < M:
                if board[nx][ny] == 0 and visited[nx][ny] == 0:
                    visited[nx][ny] = 1
                    q.append((nx, ny))
                elif board[nx][ny] == 1:
                    visited[nx][ny] += 1
                    if visited[nx][ny] >= 2:
                        board[nx][ny] = 0
                        one_cnt -= 1


result = 0

while True:
    bfs(0, 0)
    result += 1
    if one_cnt == 0:
        print(result)
        break
    if result >= N * M * 2:
        print(-1)
        break