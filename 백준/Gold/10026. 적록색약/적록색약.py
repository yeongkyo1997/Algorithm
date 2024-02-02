import sys

sys.setrecursionlimit(10 ** 5)


def input(): return sys.stdin.readline().rstrip()


N = int(input())
board = [list(input()) for _ in range(N)]


d = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def dfs(x, y, color):
    if x < 0 or y < 0 or x >= N or y >= N or visited[x][y] or board[x][y] != color:
        return

    visited[x][y] = True
    if board[x][y] == 'R':
        board[x][y] = 'G'
    for dx, dy in d:
        nx, ny = x + dx, y + dy

        dfs(nx, ny, color)


def cnt():
    global visited
    visited = [[False] * N for _ in range(N)]
    result = 0
    for i in range(N):
        for j in range(N):
            if not visited[i][j]:
                dfs(i, j, board[i][j])
                result += 1
    return result


print(cnt(), cnt())