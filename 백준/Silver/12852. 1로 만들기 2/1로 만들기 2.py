import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())

path = [[] for _ in range(N + 1)]
path[1] = [1]
dp = [0] * (N + 1)


for i in range(2, N + 1):
    dp[i] = dp[i - 1] + 1
    path[i] = path[i - 1] + [i]

    if i % 2 == 0 and dp[i] > dp[i // 2] + 1:
        dp[i] = dp[i // 2] + 1
        path[i] = path[i // 2] + [i]

    if i % 3 == 0 and dp[i] > dp[i // 3] + 1:
        dp[i] = dp[i // 3] + 1
        path[i] = path[i // 3] + [i]

print(dp[N])
print(*path[N][::-1])