import sys

input = lambda: sys.stdin.readline().rstrip()


def count_coin_change(n, coins, m):
    dp = [0] * (m + 1)
    dp[0] = 1

    for coin in coins:
        for i in range(coin, m + 1):
            dp[i] += dp[i - coin]

    return dp[m]


def main():
    for _ in range(int(input())):
        n = int(input())
        coins = list(map(int, input().split()))
        m = int(input())
        print(count_coin_change(n, coins, m))


if __name__ == '__main__':
    main()