import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())

board = [[0] * 101 for _ in range(101)]

for _ in range(N):
    a, b = map(int, input().split())

    for i in range(a, a + 10):
        for j in range(b, b + 10):
            board[i][j] = 1

print(sum(row.count(1) for row in board))