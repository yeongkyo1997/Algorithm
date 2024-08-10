dir = [(-1, 0), (0, 1), (1, 0), (0, -1)]

N, M = map(int, input().split())

x, y, d = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]


def move(x, y, d):
    result = 0
    while True:
        if board[x][y] == 0:
            result += 1
            board[x][y] = -1

        for i in range(4):
            d = (d - 1) % 4
            dx, dy = dir[d]
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < M:
                if board[nx][ny] == 0:
                    x, y = nx, ny
                    break
        else:
            dx, dy = dir[d]
            x -= dx
            y -= dy
            if x < 0 or x >= N or y < 0 or y >= M:
                break
            if board[x][y] == 1:
                break

    return result


print(move(x, y, d))