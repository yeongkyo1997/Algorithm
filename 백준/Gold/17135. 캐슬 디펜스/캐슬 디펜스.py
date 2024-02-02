from copy import deepcopy
from itertools import combinations


def simulate(N, M, D, board, archers):
    ret = 0
    cp_board = deepcopy(board)

    for _ in range(N):
        targets = set()
        for archer in archers:
            target = None
            min_dist = D + 1
            for i in range(N - 1, -1, -1):
                for j in range(M):
                    if cp_board[i][j] == 1:
                        dist = abs(N - i) + abs(archer - j)
                        if dist <= D:
                            if dist < min_dist or (dist == min_dist and j < target[1]):
                                target = (i, j)
                                min_dist = dist
            if target:
                targets.add(target)

        for i, j in targets:
            if cp_board[i][j] == 1:
                cp_board[i][j] = 0
                ret += 1

        cp_board.pop()
        cp_board.insert(0, [0] * M)

    return ret


def solution(N, M, D, board):
    ret = 0
    for comb in combinations(range(M), 3):
        ret = max(ret, simulate(N, M, D, board, comb))
    return ret


N, M, D = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

print(solution(N, M, D, board))