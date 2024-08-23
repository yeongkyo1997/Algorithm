import copy
import math

dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def get_line(board, core, d):
    x, y = core
    result = 0
    dx, dy = dir[d]
    while True:
        x += dx
        y += dy

        result += 1

        if board[x][y] == 1:
            return -1
        board[x][y] = 1

        if x == 0 or x == N - 1 or y == 0 or y == N - 1:
            return result


# 코어 선택하기
def dfs(board, depth, cur_core, cur_len):
    global min_len, max_core

    if len(core) - depth + cur_core < max_core:
        return

    if depth == len(core):
        if cur_core == max_core:
            min_len = min(min_len, cur_len)
        elif cur_core > max_core:
            min_len = cur_len
            max_core = cur_core
        return

    for d in range(len(dir)):
        tmp = copy.deepcopy(board)
        l = get_line(tmp, core[depth], d)

        if l >= 1:
            dfs(tmp, depth + 1, cur_core + 1, cur_len + l)
        else:
            dfs(tmp, depth + 1, cur_core, cur_len)


for t in range(1, int(input().rstrip()) + 1):
    N = int(input().rstrip())
    board = [list(map(int, input().rstrip().split())) for _ in range(N)]

    core = []
    for i in range(1, N - 1):
        for j in range(1, N - 1):
            if board[i][j] == 1:
                core.append((i, j))
    max_core = -math.inf
    min_len = math.inf

    dfs(board, 0, 0, 0)
    print(f'#{t} {min_len}')
