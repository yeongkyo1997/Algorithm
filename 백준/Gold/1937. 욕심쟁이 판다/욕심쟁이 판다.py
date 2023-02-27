import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]
    dp = [[0] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            dp[i][j] = dfs(i, j, N, arr, dp)
    print(max(map(max, dp)))

def dfs(i, j, N, arr, dp):
    if dp[i][j]:
        return dp[i][j]
    dp[i][j] = 1
    for di, dj in ((-1, 0), (1, 0), (0, -1), (0, 1)):
        ni, nj = i + di, j + dj
        if 0 <= ni < N and 0 <= nj < N and arr[ni][nj] > arr[i][j]:
            dp[i][j] = max(dp[i][j], dfs(ni, nj, N, arr, dp) + 1)
    return dp[i][j]

if __name__ == '__main__':
    main()