import copy
import math
import sys


def input(): return sys.stdin.readline().rstrip()


dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

mode = [
    [],
    [[0], [1], [2], [3]],
    [[0, 1], [2, 3]],
    [[0, 2], [0, 3], [1, 2], [1, 3]],
    [[0, 1, 2], [0, 1, 3], [0, 2, 3], [1, 2, 3]],
    [[0, 1, 2, 3]]
]

N, M = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]
result = math.inf
cctv = []

for i in range(len(board)):
    for j in range(len(board[i])):
        if 1 <= board[i][j] <= 5:
            cctv.append((i, j, board[i][j]))


# 감시영역 체크
def watch(x, y, mode, board):
    for i in mode:
        nx = x
        ny = y
        while True:
            nx += dx[i]
            ny += dy[i]

            if nx < 0 or ny < 0 or nx >= N or ny >= M:
                break

            if board[nx][ny] == 6:
                break

            if board[nx][ny] == 0:
                board[nx][ny] = -1


# dfs 탐색
def dfs(depth, board):
    global result

    if depth == len(cctv):
        cnt = 0
        for i in range(len(board)):
            for j in range(len(board[i])):
                if board[i][j] == 0:
                    cnt += 1

        result = min(cnt, result)
        return

    cp_board = copy.deepcopy(board)
    x, y, cctv_mode = cctv[depth]

    for i in mode[cctv_mode]:
        watch(x, y, i, cp_board)
        dfs(depth + 1, cp_board)
        cp_board = copy.deepcopy(board)


dfs(0, board)
print(result)