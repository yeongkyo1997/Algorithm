import sys

sys.setrecursionlimit(10000)
input = sys.stdin.readline

result = []


def dfs(x, y):
    dx = [0, 0, 1, -1]
    dy = [-1, 1, 0, 0]
    arr[x][y] = 0

    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]

        if 0 <= nx < row and 0 <= ny < col and arr[nx][ny]:
            dfs(nx, ny)


for t in range(int(input())):
    row, col, num = map(int, input().split())
    arr = [[0] * col for _ in range(row)]
    for i in range(num):
        x, y = map(int, input().split())
        arr[x][y] = 1

    res = 0

    for i in range(row):
        for j in range(col):
            if arr[i][j]:
                dfs(i, j)
                res += 1
    result.append(res)

for i in result:
    print(i)
