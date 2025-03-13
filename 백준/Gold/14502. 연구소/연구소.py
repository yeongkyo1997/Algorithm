import sys
from collections import deque
import copy

input = lambda: sys.stdin.readline().rstrip()

d = [(0, -1), (0, 1), (-1, 0), (1, 0)]


def dfs(path, start, depth):
    global result
    if depth == 3:
        q = deque(virus)
        tmp = copy.deepcopy(board)
        for px, py in path:
            tmp[px][py] = 1

        while q:
            x, y = q.popleft()

            for dx, dy in d:
                nx, ny = x + dx, y + dy

                if 0 <= nx < N and 0 <= ny < M and tmp[nx][ny] == 0:
                    tmp[nx][ny] = 2
                    q.append((nx, ny))

        cnt = 0
        for i in range(N):
            for j in range(M):
                if tmp[i][j] == 0:
                    cnt += 1

        result = max(result, cnt)
        return

    for i in range(start, len(zero)):
        path.append(zero[i])
        dfs(path, i + 1, depth + 1)
        path.pop()


N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

virus = []
zero = []

for i in range(N):
    for j in range(M):
        if board[i][j] == 2:
            virus.append((i, j))
        elif board[i][j] == 0:
            zero.append((i, j))

result = 0
dfs([], 0, 0)
print(result)
