import sys

tc = int(sys.stdin.readline())

for _ in range(tc):
    n = int(sys.stdin.readline())

    stickers = [[0] * (n+1) for _ in range(2)]
    dp = [[0] * (n+1) for _ in range(2)]
    for j in range(2):
        inputs = list(map(int, sys.stdin.readline().split()))
        for k in range(1, n+1):
            stickers[j][k] = inputs[k-1]

    dp[0][1] = stickers[0][1]
    dp[1][1] = stickers[1][1]

    for j in range(2, n+1):
        dp[0][j] = max(dp[1][j - 1], dp[1][j - 2]) + stickers[0][j]
        dp[1][j] = max(dp[0][j - 1], dp[0][j - 2]) + stickers[1][j]

    print(max(dp[0][n], dp[1][n]))