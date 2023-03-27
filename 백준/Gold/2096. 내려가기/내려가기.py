import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    N = int(input())
    max_dp = [0] * 3
    min_dp = [0] * 3
    for i in range(N):
        a, b, c = map(int, input().split())
        max_dp[0], max_dp[1], max_dp[2] = max(max_dp[0], max_dp[1]) + a, max(max_dp) + b, max(max_dp[1], max_dp[2]) + c
        min_dp[0], min_dp[1], min_dp[2] = min(min_dp[0], min_dp[1]) + a, min(min_dp) + b, min(min_dp[1], min_dp[2]) + c
    print(max(max_dp), min(min_dp))

if __name__ == '__main__':
    main()