import sys
sys.setrecursionlimit(10 ** 5)


def input(): return sys.stdin.readline().rstrip()


d = [(-1, 0), (1, 0), (0, -1), (0, 1)]

T = int(input())


def dfs(x, y):
    if x < 0 or x >= N or y < 0 or y >= M or board[x][y] == 0:
        return 1

    board[x][y] = 0
    for dx, dy in d:
        nx, ny = x + dx, y + dy
        dfs(nx, ny)
    return 1


for _ in range(T):
    M, N, K = map(int, input().split())
    board = [[0] * M for _ in range(N)]

    for _ in range(K):
        X, Y = map(int, input().split())
        board[Y][X] = 1

    result = 0

    for i in range(N):
        for j in range(M):
            if board[i][j] == 1:
                result += dfs(i, j)

    print(result)