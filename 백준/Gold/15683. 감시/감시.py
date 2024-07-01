import sys
import math
import copy


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())


board = [list(map(int, input().split())) for _ in range(N)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

cctv_mode = [
    [],
    [[0], [1], [2], [3]],
    [[0, 1], [2, 3]],
    [[0, 2], [0, 3], [1, 2], [1, 3]],
    [[0, 1, 2], [0, 1, 3], [0, 2, 3], [1, 2, 3]],
    [[0, 1, 2, 3]]
]


cctv = []
result = math.inf

# cctv 설치
for i in range(len(board)):
    for j in range(len(board[i])):
        if 1 <= board[i][j] <= 5:
            cctv.append((i, j, board[i][j]))


# 감시
def check(x, y, mode, board):
    for i in mode:
        nx, ny = x, y
        while True:
            nx += dx[i]
            ny += dy[i]

            if nx < 0 or ny < 0 or nx >= N or ny >= M:
                break
            if board[nx][ny] == 6:
                break
            if board[nx][ny] == 0:
                board[nx][ny] = -1


# 사각지대 개수
def cnt_zero(board):
    cnt = 0
    for i in board:
        cnt += i.count(0)
    return cnt


# 탐색
def dfs(depth, board):
    global result
    if depth == len(cctv):
        result = min(result, cnt_zero(board))
        return

    x, y, mode = cctv[depth]

    for i in cctv_mode[mode]:
        tmp_board = copy.deepcopy(board)
        check(x, y, i, tmp_board)
        dfs(depth + 1, tmp_board)
        tmp_board = copy.deepcopy(board)


dfs(0, board)
print(result)