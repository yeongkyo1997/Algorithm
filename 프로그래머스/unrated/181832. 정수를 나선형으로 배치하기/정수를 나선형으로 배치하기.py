def solution(n):
    dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]
    board = [[0]*n for _ in range(n)]
    x, y, c = 0, 0, 0
    for i in range(n*n):
        board[x][y] = i + 1
        nx, ny = x + dx[c], y + dy[c]
        if nx < 0 or nx >= n or ny < 0 or ny >= n or board[nx][ny]:
            c = (c + 1) % 4
            nx, ny = x + dx[c], y + dy[c]
        x, y = nx, ny
    return board
