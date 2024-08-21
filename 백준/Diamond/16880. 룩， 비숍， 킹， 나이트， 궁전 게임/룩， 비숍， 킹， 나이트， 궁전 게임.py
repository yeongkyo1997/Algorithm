import sys

input = lambda: sys.stdin.readline().rstrip()

N = int(input())
xor = 0

for _ in range(N):
    x, y, chess = map(str, input().split())
    x, y = int(x), int(y)

    if chess == "R":
        xor ^= (x ^ y)

    if chess == "B":
        xor ^= min(x, y)

    if chess == "K":
        x, y = min(x, y), max(x, y)
        if x % 2 == 0:
            tmp = 0 if y % 2 == 0 else 1
        else:
            tmp = 3 if y % 2 == 0 else 2
        xor ^= tmp

    if chess == "N":
        x, y = x - min(x, y) + min(x, y) % 3, y - min(x, y) + min(x, y) % 3
        xor ^= min(x, y, (x + y) // 3)

    if chess == "P":
        xor ^= (x + y) % 3 + ((x // 3) ^ (y // 3)) * 3

print("koosaga" if xor else "cubelover")