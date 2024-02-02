import sys


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())
start = list(map(int, input().split()))
board = [list(map(int, input().split())) for _ in range(N)]
visited = [[False] * M for _ in range(N)]
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


def check(x, y):
    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == 0 and not visited[nx][ny]:
            return True
    return False


result = 1

x, y, dir = start
visited[x][y] = True
while True:
    for _ in range(4):
        dir = (dir + 3) % 4
        nx, ny = x + dx[dir], y + dy[dir]
        if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == 0 and not visited[nx][ny]:
            visited[nx][ny] = True
            result += 1
            x, y = nx, ny
            break
    else:
        if board[x - dx[dir]][y - dy[dir]] == 1:
            break
        else:
            x, y = x - dx[dir], y - dy[dir]

print(result)