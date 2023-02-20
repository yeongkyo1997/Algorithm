import sys

input = sys.stdin.readline

n = int(input())
dist = list(map(int, input().split()))
price = list(map(int, input().split()))

result = 0

cur = 0
pos = 1

while True:
    if price[cur] > price[pos]:
        result += sum(dist[cur:pos]) * price[cur]
        cur = pos
        pos += 1
        continue
    pos += 1
    if pos == len(price):
        result += sum(dist[cur:pos]) * price[cur]
        break

print(result)
