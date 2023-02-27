import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    N = int(input())
    dp = [[[0] * 10 for _ in range(1 << 10)] for _ in range(N + 1)]
    
    for i in range(1, 10):
        dp[1][1 << i][i] = 1
        
    for i in range(2, N + 1):
        for j in range(1 << 10):
            for k in range(10):
                if k == 0:
                    dp[i][j | (1 << k)][k] += dp[i - 1][j][k + 1]
                elif k == 9:
                    dp[i][j | (1 << k)][k] += dp[i - 1][j][k - 1]
                else:
                    dp[i][j | (1 << k)][k] += dp[i - 1][j][k - 1] + dp[i - 1][j][k + 1]
    print(sum(dp[N][(1 << 10) - 1]) % 1000000000)

if __name__ == '__main__':
    main()
