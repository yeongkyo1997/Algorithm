import sys

sys.setrecursionlimit(10 ** 5)
def input(): return sys.stdin.readline().rstrip()


N = int(input())
board = [list(map(int, input())) for _ in range(N)]

d = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def dfs(x, y):
    if x < 0 or y < 0 or x >= N or y >= N or not board[x][y]:
        return 0

    board[x][y] = 0
    ret = 1
    for dx, dy in d:
        ret += dfs(x + dx, y + dy)

    return ret


result = []
for i in range(N):
    for j in range(N):
        if board[i][j] == 1:
            result.append(dfs(i, j))

print(len(result))
result.sort()
print(*result, sep='\n')