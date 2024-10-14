import sys


def tsp(N, board):
    INF = float('inf')
    dp = [[INF] * (1 << N) for _ in range(N)]
    dp[0][1] = 0

    for visited in range(1 << N):
        for last in range(N):
            if not (visited & (1 << last)):
                continue
            for next in range(N):
                if visited & (1 << next):
                    continue
                if board[last][next] == 0:
                    continue
                next_visited = visited | (1 << next)
                dp[next][next_visited] = min(dp[next][next_visited], dp[last][visited] + board[last][next])

    res = INF
    for i in range(1, N):
        if board[i][0] != 0:
            res = min(res, dp[i][(1 << N) - 1] + board[i][0])
    return res if res != INF else -1


if __name__ == '__main__':
    N = int(input())
    board = [list(map(int, input().split())) for _ in range(N)]
    result = tsp(N, board)
    print(result)