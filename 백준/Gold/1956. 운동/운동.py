import sys


def input(): return sys.stdin.readline().rstrip()


V, E = map(int, input().split())

board = [[float('inf')] * (V + 1) for _ in range(V + 1)]

for _ in range(E):
    a, b, c = map(int, input().split())
    board[a][b] = c

for k in range(1, V + 1):
    for i in range(1, V + 1):
        for j in range(1, V + 1):
            board[i][j] = min(board[i][j], board[i][k] + board[k][j])

result = float('inf')
for i in range(1, V + 1):
    result = min(board[i][i], result)

print(result if result != float('inf') else -1)