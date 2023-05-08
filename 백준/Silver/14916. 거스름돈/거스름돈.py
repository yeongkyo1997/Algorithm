import collections
import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())

    dp = collections.defaultdict(int)

    dp[2] = 1
    dp[4] = 2
    dp[5] = 1

    for i in range(6, n + 1):
        if i % 5 == 0:
            dp[i] = i // 5
        else:
            dp[i] = dp[i - 2] + 1

    print(dp[n] if dp[n] != 0 else -1)


if __name__ == '__main__':
    main()