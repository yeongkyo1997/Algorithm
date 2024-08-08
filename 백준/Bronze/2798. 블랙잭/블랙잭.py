import itertools
import math

N, M = map(int, input().split())
arr = list(map(int, input().split()))

result = -math.inf
for c in itertools.combinations(arr, 3):
    val = sum(c)
    if val <= M:
        result = max(result, val)
print(result)