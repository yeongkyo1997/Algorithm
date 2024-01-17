import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())

dp = [[[0] * (1 << 10) for _ in range(10)] for _ in range(N)]

MOD = 10 ** 9
for i in range(1, 10):
    dp[0][i][1 << i] = 1

for i in range(1, N):
    for j in range(10):
        for k in range(1 << 10):
            if j - 1 >= 0:
                dp[i][j][k | (1 << j)] += dp[i - 1][j - 1][k]
            if j + 1 <= 9:
                dp[i][j][k | (1 << j)] += dp[i - 1][j + 1][k]
            dp[i][j][k | (1 << j)] %= MOD

result = 0
for i in range(10):
    result += dp[N - 1][i][(1 << 10) - 1]
    result %= MOD

print(result)