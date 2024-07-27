import collections
import math

N, M = map(int, input().rstrip().split())

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

board = [list(map(int, input().rstrip())) for _ in range(N)]


def bfs():
    q = collections.deque()
    visited = [[[math.inf] * 2 for _ in range(M)] for _ in range(N)]
    q.append((0, 0, 0))
    visited[0][0][0] = 1
    while q:
        x, y, flag = q.popleft()
        if x == N - 1 and y == M - 1:
            return visited[x][y][flag]

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]

            if 0 <= nx < N and 0 <= ny < M:
                if board[nx][ny] == 0 and visited[nx][ny][flag] > visited[x][y][flag] + 1:
                    visited[nx][ny][flag] = visited[x][y][flag] + 1
                    q.append((nx, ny, flag))
                elif board[nx][ny] == 1 and flag == 0 and visited[nx][ny][1] > visited[x][y][flag] + 1:
                    visited[nx][ny][1] = visited[x][y][flag] + 1
                    q.append((nx, ny, 1))

    return -1


print(bfs())