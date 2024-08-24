import collections
import sys

input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

board = [list(map(int, input())) for _ in range(N)]


def bfs(x, y, index):
    q = collections.deque()
    q.append((x, y))
    visited[x][y] = index
    cnt = 1

    while q:
        x, y = q.popleft()

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]

            if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == 0 and visited[nx][ny] == -1:
                visited[nx][ny] = index
                q.append((nx, ny))
                cnt += 1

    return cnt


visited = [[-1] * M for _ in range(N)]
area_size = []
index = 0

for i in range(N):
    for j in range(M):
        if board[i][j] == 0 and visited[i][j] == -1:
            size = bfs(i, j, index)
            area_size.append(size)
            index += 1

result = [[0] * M for _ in range(N)]
for i in range(N):
    for j in range(M):
        if board[i][j] == 1:
            walls = set()
            for d in range(4):
                ni, nj = i + dx[d], j + dy[d]
                if 0 <= ni < N and 0 <= nj < M and board[ni][nj] == 0:
                    walls.add(visited[ni][nj])
            total = 1
            for area in walls:
                total += area_size[area]
            result[i][j] = total % 10
        print(result[i][j], end='')
    print()