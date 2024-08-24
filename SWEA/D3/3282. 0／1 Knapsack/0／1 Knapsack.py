def knapsack(K, items):
    dp = [0] * (K + 1)

    for v, c in items:
        for j in range(K, v - 1, -1):
            dp[j] = max(dp[j], dp[j - v] + c)

    return dp[K]


for t in range(1, int(input()) + 1):
    N, K = map(int, input().rstrip().split())
    items = [list(map(int, input().rstrip().split())) for _ in range(N)]
    max_value = knapsack(K, items)
    print(f'#{t} {max_value}')
