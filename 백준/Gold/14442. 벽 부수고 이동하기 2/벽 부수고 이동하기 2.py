import collections
import math

N, M, K = map(int, input().rstrip().split())

board = [list(map(int, input().rstrip())) for _ in range(N)]
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]


def bfs():
    q = collections.deque()
    visited = [[[math.inf] * (K + 1) for _ in range(M)] for _ in range(N)]
    visited[0][0][0] = 1
    q.append((0, 0, 0))

    while q:
        x, y, w = q.popleft()
        if x == N - 1 and y == M - 1:
            return visited[x][y][w]

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]

            if 0 <= nx < N and 0 <= ny < M:
                if board[nx][ny] == 0 and visited[nx][ny][w] > visited[x][y][w] + 1:
                    visited[nx][ny][w] = visited[x][y][w] + 1
                    q.append((nx, ny, w))
                elif board[nx][ny] == 1 and w + 1 <= K and visited[nx][ny][w + 1] > visited[x][y][w] + 1:
                    visited[nx][ny][w + 1] = visited[x][y][w] + 1
                    q.append((nx, ny, w + 1))

    return -1


print(bfs())