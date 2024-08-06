dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]
N = int(input())
board = [list(map(int, input())) for _ in range(N)]

visited = [[False] * N for _ in range(N)]


def dfs(x, y):
    if visited[x][y]:
        return 0

    visited[x][y] = True
    result = 1

    for dx, dy in dir:
        nx, ny = x + dx, y + dy
        if 0 <= nx < N and 0 <= ny < N and board[nx][ny] == 1:
            board[nx][ny] = 0
            result += dfs(nx, ny)

    return result


arr = []

for i in range(N):
    for j in range(N):
        if board[i][j] == 1:
            arr.append(dfs(i, j))

print(len(arr))
print(*sorted(arr), sep='\n')