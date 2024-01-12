N, K = map(int, input().split())
coins = []

for _ in range(N):
    coin = int(input())
    coins.append(coin)

count = 0
for i in range(N - 1, -1, -1):
    if K >= coins[i]:
        count += K // coins[i]
        K %= coins[i]

print(count)