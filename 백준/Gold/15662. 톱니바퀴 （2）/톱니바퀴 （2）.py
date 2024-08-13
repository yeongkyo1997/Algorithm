import collections
import copy
import sys

input = lambda: sys.stdin.readline().rstrip()

T = int(input())

board = [collections.deque(map(int, input())) for _ in range(T)]

K = int(input())


def rotate(x, clock):
    n_clock = -clock
    board[x].rotate(clock)
    for i in range(x, 0, -1):
        if tmp[i][-2] != tmp[i - 1][2]:
            board[i - 1].rotate(n_clock)
            n_clock *= -1
        else:
            break
    n_clock = -clock
    for i in range(x, T - 1):
        if tmp[i][2] != tmp[i + 1][-2]:
            board[i + 1].rotate(n_clock)
            n_clock *= -1
        else:
            break


for _ in range(K):
    tmp = copy.deepcopy(board)
    x, clock = map(int, input().split())
    rotate(x - 1, clock)

result = 0
for b in board:
    result += b[0]

print(result)