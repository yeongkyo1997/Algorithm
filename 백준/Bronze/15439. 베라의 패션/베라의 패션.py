import math

n = int(input())
print(math.comb(n, 1) * math.comb(n - 1, 1))