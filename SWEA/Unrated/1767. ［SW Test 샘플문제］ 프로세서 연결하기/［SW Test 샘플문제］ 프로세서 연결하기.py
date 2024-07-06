import copy
import math

T = int(input().rstrip())
index = 1

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


# 전선 연결
def connect_core(board, direction, x, y):
    cnt = 0
    nx = x
    ny = y
    while True:
        nx += dx[direction]
        ny += dy[direction]

        if nx < 0 or ny < 0 or nx >= N or ny >= N:
            break

        if board[nx][ny] != 0:
            cnt = 0
            break

        cnt += 1
        board[nx][ny] = 2

    return cnt


# 코어 subset
def dfs(board, core_idx, cur_core_cnt, cur_wire_len):
    global max_core_cnt, min_wire_len
    if len(core) - core_idx + cur_core_cnt < max_core_cnt:
        return
    if core_idx == len(core):
        if cur_core_cnt > max_core_cnt:
            max_core_cnt = cur_core_cnt
            min_wire_len = cur_wire_len
        elif cur_core_cnt == max_core_cnt:
            min_wire_len = min(min_wire_len, cur_wire_len)
        return

    x, y = core[core_idx]
    for d in range(4):
        tmp_board = copy.deepcopy(board)
        wire_len = connect_core(tmp_board, d, x, y)

        if wire_len > 0:
            dfs(tmp_board, core_idx + 1, cur_core_cnt + 1, cur_wire_len + wire_len)
        else:
            dfs(board, core_idx + 1, cur_core_cnt, cur_wire_len)


results = []

for t in range(T):
    N = int(input().rstrip())
    index += 1
    board = [list(map(int, input().rstrip().split())) for i in range(index, index + N)]
    index += N

    core = []
    max_core_cnt = 0
    min_wire_len = math.inf

    for i in range(N):
        for j in range(N):
            if board[i][j] == 1 and (i != 0 and j != 0 and i != N - 1 and j != N - 1):
                core.append((i, j))

    dfs(board, 0, 0, 0)
    print(f'#{t + 1} {min_wire_len}')

