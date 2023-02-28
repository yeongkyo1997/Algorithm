import collections
import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    arr = [int(input()) for _ in range(n)]
    dp = collections.defaultdict(int)

    dp[0] = arr[0]
    dp[1] = max(arr[0], arr[1])
    for i in range(2, n):
        dp[i] = max(dp[i - 1], dp[i - 2] + arr[i])

    print(dp[n - 1])


if __name__ == '__main__':
    main()
