import sys
from functools import cache

sys.setrecursionlimit(10 ** 5)


def input(): return sys.stdin.readline().rstrip()


N = int(input())


board = [list(map(int, input().split())) for _ in range(N)]


@cache
def solution(row, col):
    if row == N - 1:
        return board[row][col]

    return max(solution(row + 1, col), solution(row + 1, col + 1)) + board[row][col]


print(solution(0, 0))