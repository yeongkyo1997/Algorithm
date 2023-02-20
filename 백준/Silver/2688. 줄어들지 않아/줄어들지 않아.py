import sys

input = sys.stdin.readline

t = int(input())

dp = [[0] * 10 for i in range(65)]

for i in range(10):
    dp[1][i] = 1
for i in range(2, 65):
    for j in range(0, 10):
        for k in range(j, 10):
            dp[i][j] += dp[i - 1][k]
while t:
    t -= 1
    n = int(input())
    result = 0
    for i in range(10):
        result += dp[n][i]
    print(result)
