import sys
from functools import cache

sys.setrecursionlimit(10 ** 5)


def input(): return sys.stdin.readline().rstrip()


N = int(input())

board = [list(map(int, input().split())) for _ in range(N)]


@cache
def solution(row, col):
    if row == N:
        return 0

    result = float('inf')

    for i in range(0, 3):
        if col != i:
            result = min(result, solution(row + 1, i))

    return result + board[row][col]


print(min([solution(0, 0), solution(0, 1), solution(0, 2)]))