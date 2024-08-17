import copy
import math

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def connect(board, x, y, d):
    ret = 0
    while True:
        x += dx[d]
        y += dy[d]

        ret += 1

        if board[x][y] == 1:
            return 0
        board[x][y] = 1

        if x == 0 or x == N - 1 or y == 0 or y == N - 1:
            return ret


# 순열을 구해야함
def dfs(board, depth, connected_core, connected_length):
    global max_core, min_length
    if len(core) - depth + connected_core < max_core:
        return
    if depth == len(core):
        if connected_core > max_core:
            max_core = connected_core
            min_length = connected_length
        elif connected_core == max_core:
            min_length = min(min_length, connected_length)

        return

    x, y = core[depth]
    for d in range(4):
        tmp = copy.deepcopy(board)
        length = connect(tmp, x, y, d)
        if length > 0:
            dfs(tmp, depth + 1, connected_core + 1, connected_length + length)
        else:
            dfs(tmp, depth + 1, connected_core, connected_length)

for t in range(1, int(input()) + 1):
    N = int(input())
    board = [list(map(int, input().rstrip().split())) for _ in range(N)]

    core = []
    max_core = -math.inf
    min_length = math.inf

    for i in range(1, N - 1):
        for j in range(1, N - 1):
            if board[i][j] == 1:
                core.append((i, j))

    dfs(board, 0, 0, 0)
    print(f'#{t} {min_length}')
