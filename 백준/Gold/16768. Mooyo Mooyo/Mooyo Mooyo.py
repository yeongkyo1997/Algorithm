import collections
import copy

dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]

N, K = map(int, input().split())
M = 10

board = [list(map(int, input())) for _ in range(N)]


def bfs(x, y, num):
    q = collections.deque()
    path = {(x, y)}
    q.append((x, y))
    while q:
        x, y = q.popleft()

        for dx, dy in dir:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == num and (nx, ny) not in path:
                path.add((nx, ny))
                q.append((nx, ny))

    if len(path) >= K:
        for x, y in path:
            board[x][y] = 0
        return True
    return False


def move_down():
    for col in range(M):
        stack = []
        for row in range(N):
            if board[row][col] != 0:
                stack.append(board[row][col])
                board[row][col] = 0

        for row in range(N - 1, 0, -1):
            if stack:
                board[row][col] = stack.pop()


while True:
    flag = False
    for i in range(N):
        for j in range(M):
            if board[i][j] != 0:
                if bfs(i, j, board[i][j]):
                    flag = True

    move_down()
    if not flag:
        break

for b in board:
    print(*b, sep='')