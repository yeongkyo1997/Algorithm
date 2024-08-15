import math


def dfs(path, depth, start):
    global result
    if depth == N // 2:
        a, b = 0, 0

        for i in range(N):
            for j in range(i + 1, N):
                if i in path and j in path:
                    a += board[i][j] + board[j][i]
                if i not in path and j not in path:
                    b += board[i][j] + board[j][i]
        result = min(abs(a - b), result)
        return

    for i in range(start, N):
        dfs(path | {i}, depth + 1, i + 1)


for t in range(1, int(input()) + 1):
    N = int(input())
    board = [list(map(int, input().split())) for _ in range(N)]
    result = math.inf
    dfs(set(), 0, 0)
    print(f'#{t} {result}')
