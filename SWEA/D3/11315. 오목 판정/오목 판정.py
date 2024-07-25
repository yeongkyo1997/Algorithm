T = int(input())
dx = [0, 1, 1, 1]
dy = [1, 0, 1, -1]


def check(x, y):
    for d in range(4):
        cnt = 0
        nx = x
        ny = y

        while 0 <= nx < N and 0 <= ny < N and board[nx][ny] == 'o':
            cnt += 1
            nx += dx[d]
            ny += dy[d]

        if cnt >= 5:
            return True

    return False


for t in range(1, T + 1):
    N = int(input())

    board = [list(input()) for _ in range(N)]
    result = 'NO'
    for i in range(N):
        for j in range(N):
            if board[i][j] == 'o':
                if check(i, j):
                    result = 'YES'
                    break

        if result == 'YES':
            break

    print(f'#{t} {result}')
