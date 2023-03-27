import sys

sys.setrecursionlimit(10000)
input = sys.stdin.readline


def dfs(x, y):
    global arr
    a += 1
    arr[x][y] = 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx >= 0 and ny >= 0 and nx < N and ny < N and arr[nx][ny] == 1:
            arr[nx][ny] = 0
            dfs(nx, ny)


N = int(input())
result = []

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

arr = [list(map(int, input().rstrip())) for _ in range(N)]

for i in range(N):
    for j in range(N):
        if arr[i][j] == 1:
            arr = 0
            dfs(i, j)
            result.append(arr)

print(len(result))

result = sorted(result)

for i in result:
    print(i)
