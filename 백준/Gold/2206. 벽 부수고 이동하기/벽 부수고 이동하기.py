import collections

dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]

N, M = map(int, input().split())

board = [list(map(int, input())) for _ in range(N)]


def bfs():
    q = collections.deque()
    visited = [[[False] * 2 for _ in range(M)] for _ in range(N)]
    q.append((0, 0, 0, 1))
    visited[0][0][0] = True

    while q:
        x, y, wall, depth = q.popleft()
        if x == N - 1 and y == M - 1:
            return depth
        for dx, dy in dir:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < M:
                # 벽이 아니라면
                if board[nx][ny] == 0:
                    if not visited[nx][ny][wall]:
                        visited[nx][ny][wall] = True
                        q.append((nx, ny, wall, depth + 1))
                elif board[nx][ny] == 1:
                    if wall == 0:
                        visited[nx][ny][wall + 1] = True
                        q.append((nx, ny, wall + 1, depth + 1))

    return -1


print(bfs())