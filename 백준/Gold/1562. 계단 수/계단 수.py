import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

MOD = 1000000000
N = int(input())
dp = [[[0] * 1024 for _ in range(10)] for _ in range(101)]
full = 1023
for j in range(1, 10):
    dp[1][j][1 << j] = 1

for i in range(2, N + 1):
    for j in range(10):
        for k in range(1024):
            if j == 0:
                dp[i][0][k | (1 << 0)] = (dp[i][0][k | (1 << 0)] + dp[i - 1][1][k]) % MOD
            elif j == 9:
                dp[i][9][k | (1 << 9)] = (dp[i][9][k | (1 << 9)] + dp[i - 1][8][k]) % MOD
            else:
                dp[i][j][k | (1 << j)] = (dp[i][j][k | (1 << j)] + dp[i - 1][j - 1][k]) % MOD
                dp[i][j][k | (1 << j)] = (dp[i][j][k | (1 << j)] + dp[i - 1][j + 1][k]) % MOD

result = 0
for j in range(10):
    result = (result + dp[N][j][full]) % MOD
print(result)
