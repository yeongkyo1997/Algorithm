import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()


M, N = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]

dxy = [(-1, 0), (1, 0), (0, -1), (0, 1)]

zero_cnt = sum(b.count(0) for b in board)
tomatos = [(i, j, 0) for i in range(N) for j in range(M) if board[i][j] == 1]

result = 0

q = deque(tomatos)

while q:
    x, y, day = q.popleft()

    for dx, dy in dxy:
        nx, ny = x + dx, y + dy

        if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == 0:
            board[nx][ny] = 1
            zero_cnt -= 1
            if zero_cnt == 0:
                result = max(day + 1, result)
            q.append((nx, ny, day + 1))

if zero_cnt == 0:
    print(result)
else:
    print(-1)
