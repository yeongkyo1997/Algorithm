for _ in range(1, 11):
    t = int(input())
    N = 100
    board = [list(map(int, input().split())) for _ in range(N)]
    x, y = -1, -1

    for col in range(N):
        if board[N - 1][col] == 2:
            x, y = N - 1, col
            break
    result = 0

    while True:
        # 왼쪽 체크
        while 0 <= y - 1 < N and board[x][y - 1] == 1:
            y -= 1
            if board[x - 1][y] == 1:
                x -= 1

        # 오른쪽 체크
        while 0 <= y + 1 < N and board[x][y + 1] == 1:
            y += 1
            if board[x - 1][y] == 1:
                x -= 1

        if x == 0:
            result = y
            break
        x -= 1

    print(f'#{t} {result}')
