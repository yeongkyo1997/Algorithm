import sys
from itertools import product


def input(): return sys.stdin.readline().rstrip()


n, k = map(int, input().split())
result = []
for i in range(1, 11):
    for s in product(range(1, 4), repeat=i):
        if sum(s) == n:
            result.append(s)

if len(result) < k:
    print(-1)
else:
    print(*sorted(result)[k - 1], sep='+')
