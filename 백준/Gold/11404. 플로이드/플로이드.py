N = int(input())
M = int(input())
inf = 1e10
board = [[inf] * (N + 1) for _ in range(N + 1)]
for i in range(1, N + 1):
    for j in range(1, N + 1):
        if i == j:
            board[i][j] = 0
for _ in range(M):
    a, b, c = map(int, input().split())
    board[a][b] = min(board[a][b], c)

for k in range(1, N + 1):
    for i in range(1, N + 1):
        for j in range(1, N + 1):
            board[i][j] = min(board[i][j], board[i][k] + board[k][j])

for i in range(1, N + 1):
    for j in range(1, N + 1):
        if board[i][j] == inf:
            board[i][j] = 0
        print(board[i][j], end=' ')
    print()
