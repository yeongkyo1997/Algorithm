import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

result = []


arr = []
for _ in range(N):
    arr.append(list(input()))


def dfs(x, y):
    arr[x][y] = '0'
    result = 1

    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]

        if 0 <= nx < N and 0 <= ny < N and arr[nx][ny] == '1':
            result += dfs(nx, ny)
    return result


for i in range(N):
    for j in range(N):
        if arr[i][j] == '1':
            result.append(dfs(i, j))

print(len(result))
print(*sorted(result), sep='\n')