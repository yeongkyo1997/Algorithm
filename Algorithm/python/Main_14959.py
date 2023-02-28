import sys

input = lambda: sys.stdin.readline().rstrip()


# BOJ 14959 Slot Machine
def main():
    k = int(input())
    arr = [int(input()) for _ in range(k)]
    dp = [0] * k
    dp[0] = arr[0]
    dp[1] = max(arr[0], arr[1])
    for i in range(2, k):
        dp[i] = max(dp[i - 1], dp[i - 2] + arr[i])

    print(dp[k - 1], dp[k - 2])


if __name__ == '__main__':
    main()