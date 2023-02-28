import sys

input = lambda: sys.stdin.readline().rstrip()


# BOJ 4008 특공대
def main():
    n = int(input())
    arr = list(map(int, input().split()))
    op = list(map(int, input().split()))
    dp = [[0] * n for _ in range(n)]
    dp2 = [[0] * n for _ in range(n)]
    for i in range(n):
        dp[i][i] = arr[i]
        dp2[i][i] = arr[i]

    for i in range(1, n):
        for j in range(n - i):
            dp[j][j + i] = max(dp[j][j + i - 1] + arr[j + i], dp[j + 1][j + i] + arr[j])
            dp2[j][j + i] = min(dp2[j][j + i - 1] + arr[j + i], dp2[j + 1][j + i] + arr[j])

    print(dp[0][n - 1], dp2[0][n - 1])


if __name__ == '__main__':
    main()
