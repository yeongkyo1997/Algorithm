import sys
import copy


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

d = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def dfs(x, y):
    if x == 0 or y == 0 or x == N - 1 or y == M - 1:
        return True

    for dx, dy in d:
        nx, ny = x + dx, y + dy

        if 0 <= nx < N and 0 <= ny < M and pre_board[nx][ny] == 0 and not visited[nx][ny]:
            visited[nx][ny] = True
            if dfs(nx, ny):
                return True

    return False


def check(board):
    for i in range(N):
        for j in range(M):
            if board[i][j] != 0:
                return False

    return True


result = 0
while True:
    pre_board = copy.deepcopy(board)
    for i in range(N):
        for j in range(M):
            if board[i][j] == 1:
                visited = [[False] * M for _ in range(N)]
                if dfs(i, j):
                    board[i][j] = 0
    result += 1

    if check(board):
        print(result)
        cnt = 0
        for i in range(N):
            for j in range(M):
                if pre_board[i][j] == 1:
                    cnt += 1

        print(cnt)
        break