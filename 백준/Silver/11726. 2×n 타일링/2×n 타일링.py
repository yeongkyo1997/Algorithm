import collections
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    dp = collections.defaultdict(lambda: 0)
    dp[1] = 1
    dp[2] = 2
    MOD = 10007

    for i in range(3, 1001):
        dp[i] = dp[i - 1] % MOD + dp[i - 2] % MOD

    print(dp[n] % 10007)


if __name__ == '__main__':
    main()