import sys

input = lambda: sys.stdin.readline().rstrip()

dxy = [(-1, 0), (0, 1), (1, 0), (0, -1)]


def move(x, y, d):
    ret = 0
    clean = [[0] * M for _ in range(N)]

    while True:
        # 현재 청소가 되지 않은 경우
        if clean[x][y] == 0:
            ret += 1
            clean[x][y] = 1

        # 청소가 되지 않은 빈칸 찾기
        for i in range(4):
            d = (d - 1) % 4
            dx, dy = dxy[d]
            nx, ny = x + dx, y + dy

            if (
                0 <= nx < N
                and 0 <= ny < M
                and board[nx][ny] == 0
                and clean[nx][ny] == 0
            ):
                x, y = nx, ny
                break
        # 빈칸이 없다면
        else:
            dx, dy = dxy[d]
            nx, ny = x - dx, y - dy

            if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == 0:
                x, y = nx, ny
            else:
                break

    return ret


N, M = map(int, input().split())

r, c, d = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]
result = move(r, c, d)
print(result)
