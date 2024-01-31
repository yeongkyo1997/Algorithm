import sys


def input(): return sys.stdin.readline().rstrip()


N, K = map(int, input().split())
knapsack = [[0, 0]]
dp = [[0] * (K + 1) for _ in range(N + 1)]

for i in range(N):
    knapsack.append(list(map(int, input().split())))

for i in range(1, N + 1):
    for j in range(1, K + 1):
        w, v = knapsack[i]

        if j < w:  # 무게가 초과되면
            dp[i][j] = dp[i - 1][j]
        else:  # 무게가 초과되지 않으면
            dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - w] + v)

print(dp[N][K])