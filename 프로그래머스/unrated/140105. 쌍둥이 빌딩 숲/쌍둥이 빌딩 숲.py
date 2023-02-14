def solution(n, count):
    MOD = 1000000007

    DP = [[0] * 101 for _ in range(101)]

    for i in range(1, n + 1):
        DP[i][i] = 1

    for i in range(1, n + 1):
        for j in range(1, count + 1):
            if i == j:
                continue

            DP[i][j] = (DP[i - 1][j] * 2 * (i - 1)) % MOD + DP[i - 1][j - 1]
            DP[i][j] %= MOD

    return DP[n][count]
