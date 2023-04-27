import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

dp = [0, 1, 1]

for i in range(3, 41):
    dp.append(dp[i - 1] + dp[i - 2])

for i in range(int(input())):
    N = int(input())
    if N == 0:
        print(1, 0)
    elif N == 1:
        print(0, 1)
    else:
        print(dp[N - 1], dp[N])