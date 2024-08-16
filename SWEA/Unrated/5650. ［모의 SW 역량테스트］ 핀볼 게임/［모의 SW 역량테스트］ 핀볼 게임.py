import collections
import math

# 0:상 1:우 2:하 3:좌
dir = [(-1, 0), (0, 1), (1, 0), (0, -1)]
change_dir = [[],
              [2, 3, 1, 0],
              [1, 3, 0, 2],
              [3, 2, 0, 1],
              [2, 0, 3, 1],
              [2, 3, 0, 1]
              ]


def move_cnt(x, y, d):
    nx, ny = x, y
    result = 0

    while True:
        dx, dy = dir[d]
        nx += dx
        ny += dy
        if nx == x and ny == y:
            return result

        if nx < 0 or nx >= N or ny < 0 or ny >= N:
            result *= 2
            result += 1
            return result
        elif board[nx][ny] in range(1, 6):
            d = change_dir[board[nx][ny]][d]
            result += 1
        elif board[nx][ny] in range(6, 11):
            for a, b in worm_hole[board[nx][ny]]:
                if (a, b) != (nx, ny):
                    nx, ny = a, b
                    break
        elif board[nx][ny] == -1:
            return result


for t in range(1, int(input()) + 1):
    N = int(input())
    board = [list(map(int, input().split())) for _ in range(N)]

    worm_hole = collections.defaultdict(list)

    for i in range(N):
        for j in range(N):
            if 6 <= board[i][j] <= 10:
                worm_hole[board[i][j]].append((i, j))

    result = -math.inf
    for i in range(N):
        for j in range(N):
            if board[i][j] == 0:
                for d in range(4):
                    result = max(move_cnt(i, j, d), result)

    print(f'#{t} {result}')
