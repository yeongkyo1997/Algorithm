from collections import deque
import sys
sys.setrecursionlimit(10 ** 5)


def input(): return sys.stdin.readline().rstrip()


n, m = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(n)]

visited = [[False] * m for _ in range(n)]

d = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def bfs(x, y):
    q = deque([(x, y)])
    board[x][y] = 0
    ret = 1

    while q:
        x, y = q.popleft()

        for dx, dy in d:
            nx, ny = x + dx, y + dy

            if 0 <= nx < n and 0 <= ny < m and board[nx][ny] == 1:
                board[nx][ny] = 0
                q.append((nx, ny))
                ret += 1
    return ret


cnt = 0
area = 0
for i in range(n):
    for j in range(m):
        if board[i][j] == 1:
            cnt += 1
            area = max(area, bfs(i, j))

print(cnt)
print(area)