import math
from itertools import combinations

t = int(input())

for _ in range(t):
    arr = list(map(int, input().split()))[1:]
    print(sum(math.gcd(a, b) for a, b in combinations(arr, 2)))