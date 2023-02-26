import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n, k = map(int, input().split())
    dp = [0] * 100001
    dp[n] = 1
    q = [n]
    while q:
        x = q.pop(0)
        if x == k:
            print(dp[x] - 1)
            break
        for nx in [x - 1, x + 1, x * 2]:
            if 0 <= nx < 100001 and not dp[nx]:
                dp[nx] = dp[x] + 1
                q.append(nx)


if __name__ == '__main__':
    main()