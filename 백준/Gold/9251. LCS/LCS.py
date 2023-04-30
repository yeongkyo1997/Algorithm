import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

s1 = input()
s2 = input()
dp = [[0] * (len(s2) + 1) for _ in range(len(s1) + 1)]

for i in range(1, len(s1) + 1):
    for j in range(1, len(s2) + 1):
        dp[i][j] = max(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1] + (s1[i - 1] == s2[j - 1]))

print(dp[len(s1)][len(s2)])