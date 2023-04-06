import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N, k = map(int, input().split())
dp = [0] * 1000010


def pow(a, b):
    tmp = 1
    while b:
        tmp *= a
        tmp %= 1000000009
        b -= 1
    return tmp


def solve():
    if N == 5:
        return pow(k, N) - 2
    dp[0] = 1
    for i in range(1, 5):
        dp[i] = dp[i - 1] * k
    dp[5] = dp[4] * k - 2
    dp[6] = (dp[5] * k - 2 * k) % 1000000009
    for i in range(7, N + 1):
        dp[i] = k * dp[i - 1] - dp[i - 5] * 2 + dp[i - 7]
        dp[i] %= 1000000009
        if dp[i] < 0:
            dp[i] += 1000000009
    return dp[N]


print(solve() % 1000000009)
