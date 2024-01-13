import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())

board = [list(input()) for _ in range(N)]

result = []


d = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def dfs(x, y):
    if x < 0 or x >= N or y < 0 or y >= N:
        return 0

    if board[x][y] == '1':
        board[x][y] = '0'
        cnt = 1

        for dx, dy in d:
            nx, ny = x + dx, y + dy
            cnt += dfs(nx, ny)
        return cnt

    return 0


for i in range(N):
    for j in range(N):
        if board[i][j] == '1':
            result.append(dfs(i, j))

print(len(result))
result.sort()
print(*result, sep='\n')