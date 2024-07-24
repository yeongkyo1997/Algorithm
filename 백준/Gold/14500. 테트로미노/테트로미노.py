import collections

N, M = map(int, input().rstrip().split())

board = [list(map(int, input().rstrip().split())) for _ in range(N)]

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
result = 0


def dfs(x, y, depth, s):
    global result
    if depth == 4:
        result = max(result, s)
        return

    for d in range(4):
        nx, ny = x + dx[d], y + dy[d]
        if nx < 0 or ny < 0 or nx >= N or ny >= M:
            continue
        if (nx, ny) in visited:
            continue

        visited.add((nx, ny))
        dfs(nx, ny, depth + 1, s + board[nx][ny])
        visited.remove((nx, ny))


def other(x, y):
    global result
    s = board[x][y]
    arr = []

    for d in range(4):
        nx, ny = x + dx[d], y + dy[d]

        if nx < 0 or ny < 0 or nx >= N or ny >= M:
            continue

        arr.append(board[nx][ny])

    if len(arr) == 4:
        arr.sort(reverse=True)
        result = max(result, sum(arr[:-1]) + s)
    elif len(arr) == 3:
        result = max(result, sum(arr) + s)
    else:
        return


visited = set()
for i in range(N):
    for j in range(M):
        visited.add((i, j))
        dfs(i, j, 1, board[i][j])
        other(i, j)
        visited.remove((i, j))

print(result)