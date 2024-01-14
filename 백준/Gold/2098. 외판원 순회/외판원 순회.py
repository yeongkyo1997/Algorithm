from functools import cache


@cache
def dp(mask, i):
    if mask == (1 << N) - 1:
        return W[i][0] if W[i][0] else float('inf')

    cost = float('inf')
    for j in range(N):
        if mask & (1 << j) == 0 and W[i][j]:
            cost = min(cost, dp(mask | (1 << j), j) + W[i][j])
    return cost


N = int(input())
W = [list(map(int, input().split())) for _ in range(N)]

print(dp(1, 0))