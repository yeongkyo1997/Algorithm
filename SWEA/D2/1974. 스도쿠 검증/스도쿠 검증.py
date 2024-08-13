def check():
    for row in range(N):
        s = set(ele for ele in board[row])

        if len(s) != N:
            return 0
    for col in range(N):
        s = set()
        for row in range(N):
            s.add(board[row][col])
        if len(s) != N:
            return 0

    for row in range(0, N, 3):
        for col in range(0, N, 3):
            s = set()
            for i in range(row, row + 3):
                for j in range(col, col + 3):
                    s.add(board[i][j])
            if len(s) != N:
                return 0
    return 1


for t in range(1, int(input()) + 1):
    N = 9
    board = [list(map(int, input().split())) for _ in range(N)]
    print(f'#{t} {check()}')