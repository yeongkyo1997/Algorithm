dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def dfs(x, y):
    global result
    visited = [[False] * m for _ in range(n)]
    stack = []
    stack.append((x, y))

    while stack:
        x, y = stack.pop()

        if graph[x][y] == 'P':
            result += 1
        for dx, dy in dir:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny]:
                if graph[nx][ny] != 'X':
                    visited[nx][ny] = True
                    stack.append((nx, ny))


result = 0
n, m = map(int, input().split())
graph = [input() for _ in range(n)]

for i in range(n):
    for j in range(m):
        if graph[i][j] == 'I':
            dfs(i, j)
if result == 0:
    print('TT')
else:
    print(result)