def fibo(N):
    if N == 0:
        dp[0] = [1, 0]
        return dp[0]
    elif N == 1:
        dp[1] = [0, 1]
        return dp[1]

    if dp[N] != [0, 0]:
        return dp[N]
    dp[N] = [fibo(N - 1)[0] + fibo(N - 2)[0], fibo(N - 1)[1] + fibo(N - 2)[1]]
    return dp[N]


dp = [[0, 0] for _ in range(41)]

for _ in range(int(input())):
    N = int(input())
    print(*fibo(N))