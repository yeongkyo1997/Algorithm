for t in range(1, 11):
    input()
    N = 100
    board = [list(map(int, input().rstrip().split())) for _ in range(N)]
    x, y = 0, 0
    for col in range(N):
        if board[N - 1][col] == 2:
            x, y = N - 1, col

    while True:
        # 왼쪽
        if y - 1 >= 0 and board[x][y - 1] == 1:
            while y - 1 >= 0 and board[x][y - 1] == 1:
                y -= 1
            x -= 1
            continue
        # 오른쪽
        if y + 1 < N and board[x][y + 1] == 1:
            while y + 1 < N and board[x][y + 1] == 1:
                y += 1
            x -= 1
            continue

        # 위로
        if x - 1 >= 0:
            x -= 1
        if x == 0:
            print(f'#{t} {y}')
            break
