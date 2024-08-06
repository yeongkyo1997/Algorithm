import collections

dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]
N, M = map(int, input().split())

board = [list(map(int, input())) for _ in range(N)]

q = collections.deque()
q.append((0, 0, 1))

while q:
    x, y, depth = q.popleft()
    if x == N - 1 and y == M - 1:
        print(depth)
        break
    for dx, dy in dir:
        nx, ny = x + dx, y + dy

        if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == 1:
            board[nx][ny] = 0
            q.append((nx, ny, depth + 1))