import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

size = (1 << N)

result = float('inf')

for i in range(size):
    if bin(i).count('1') != N // 2:
        continue

    start = link = 0
    for j in range(N):
        for k in range(N):
            if i & (1 << j) and i & (1 << k) and j != k:
                start += board[j][k]
            elif not i & (1 << j) and not i & (1 << k) and j != k:
                link += board[j][k]
    result = min(result, abs(start - link))

print(result)