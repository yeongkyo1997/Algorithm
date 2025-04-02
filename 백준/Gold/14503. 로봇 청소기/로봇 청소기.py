import sys

input = lambda: sys.stdin.readline().rstrip()


N, M = map(int, input().split())

r, c, d = map(int, input().split())

dxy = [(-1, 0), (0, 1), (1, 0), (0, -1)]

board = [[*map(int, input().split())] for _ in range(N)]

result = 0
is_clean = set()

while True:
    if board[r][c] == 0 and (r, c) not in is_clean:
        is_clean.add((r, c))

    for i in range(4):
        d = (d - 1) % 4
        dx, dy = dxy[d]
        nr, nc = r + dx, c + dy

        if (
            0 <= nr < N
            and 0 <= nc < M
            and (nr, nc) not in is_clean
            and board[nr][nc] == 0
        ):
            r, c = nr, nc
            break
    else:
        dx, dy = dxy[d]
        r, c = r - dx, c - dy
        if board[r][c] == 1:
            break

print(len(is_clean))
