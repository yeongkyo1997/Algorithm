import sys


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]
dp = [[0] * (M + 1) for _ in range(N + 1)]

for i in range(N):
    for j in range(M):
        dp[i][j] = arr[i][j] + \
            max(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1])

print(dp[N - 1][M - 1])