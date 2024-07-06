from collections import defaultdict

T = int(input())
dx = [-1, 0, 0, 1]
dy = [0, -1, 1, 0]


def move(board, x, y, sx, sy, direction):
    score = 0
    nx, ny = x, y
    while True:
        nx += dx[direction]
        ny += dy[direction]

        # 벽에 부딪혔을 때
        if nx < 0 or ny < 0 or nx >= N or ny >= N or board[nx][ny] == 5:
            direction = 3 - direction  # (direction + 2) % 4 와 동일하지만 더 빠름
            score += 1
            continue

        block = board[nx][ny]

        # 처음으로 돌아왔을 때 또는 블랙홀에 빠졌을 때
        if (nx, ny) == (sx, sy) or block == -1:
            return score

        # 빈 공간일 때
        if block == 0:
            continue

        # 블록에 부딪혔을 때
        # 상좌우하
        if 1 <= board[nx][ny] <= 4:
            block_directions = [
                [3, 0, 1, 2],
                [2, 3, 1, 0],
                [1, 2, 3, 0],
                [3, 2, 0, 1]
            ]
            direction = block_directions[board[nx][ny] - 1][direction]
            score += 1
            continue

        # 웜홀에 빠졌을 때
        if block >= 6:
            nx, ny = wormhole[block][0] if wormhole[block][0] != (nx, ny) else wormhole[block][1]


def find_max_score():
    max_score = 0
    for i in range(N):
        for j in range(N):
            if board[i][j] == 0:
                for d in range(4):
                    max_score = max(max_score, move(board, i, j, i, j, d))
    return max_score


for t in range(1, T + 1):
    N = int(input())
    board = [list(map(int, input().split())) for _ in range(N)]
    wormhole = defaultdict(list)

    for i in range(N):
        for j in range(N):
            if board[i][j] >= 6:
                wormhole[board[i][j]].append((i, j))

    result = find_max_score()
    print(f'#{t} {result}')
