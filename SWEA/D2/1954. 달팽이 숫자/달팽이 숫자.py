dir = [(0, 1), (1, 0), (0, -1), (-1, 0)]
for t in range(1, int(input()) + 1):
    N = int(input())
    board = [[0] * N for _ in range(N)]

    x, y = 0, 0
    d = 0
    num = 1

    while N ** 2 >= num:
        dx, dy = dir[d]
        board[x][y] = num
        num += 1
        nx, ny = x + dx, y + dy

        if nx < 0 or nx >= N or ny < 0 or ny >= N or board[nx][ny] != 0:
            d = (d + 1) % 4

        dx, dy = dir[d]
        x += dx
        y += dy

    print(f'#{t}', end='\n')
    for b in board:
        print(*b)
