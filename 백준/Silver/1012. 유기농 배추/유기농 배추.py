dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def dfs(x, y):
    stack = [(x, y)]
    while stack:
        x, y = stack.pop()
        if x < 0 or x >= N or y < 0 or y >= M:
            continue
        if board[x][y] == 0:
            continue

        board[x][y] = 0
        for dx, dy in dir:
            nx, ny = x + dx, y + dy
            stack.append((nx, ny))
    return 1


for _ in range(int(input())):
    M, N, K = map(int, input().split())
    board = [[0] * M for _ in range(N)]
    graph = []
    for _ in range(K):
        y, x = map(int, input().split())
        board[x][y] = 1
        graph.append((x, y))
    result = 0
    for x, y in graph:
        if board[x][y] == 1:
            result += dfs(x, y)

    print(result)