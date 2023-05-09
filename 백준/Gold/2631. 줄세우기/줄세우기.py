import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    global n, dp
    n = int(input())
    arr = [int(input()) for _ in range(n)]

    dp = [1] * n

    for i in range(n):
        for j in range(i):
            if arr[i] > arr[j]:
                dp[i] = max(dp[i], dp[j] + 1)


if __name__ == '__main__':
    global n, dp
    main()
    print(n - max(dp))