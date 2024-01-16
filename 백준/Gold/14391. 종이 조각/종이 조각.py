import sys


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())
board = [input() for _ in range(N)]

result = 0

for i in range(1 << (N * M)):
    total = 0
    for x in range(N):
        num = 0
        for y in range(M):
            idx = x * M + y
            if i & (1 << idx):
                num *= 10
                num += int(board[x][y])
            else:
                total += num
                num = 0
        total += num
    for y in range(M):
        num = 0
        for x in range(N):
            idx = x * M + y
            if not i & (1 << idx):
                num *= 10
                num += int(board[x][y])
            else:
                total += num
                num = 0
        total += num

    result = max(result, total)


print(result)