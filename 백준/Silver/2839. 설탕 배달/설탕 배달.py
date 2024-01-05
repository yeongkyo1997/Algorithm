import sys
from collections import defaultdict


def input(): return sys.stdin.readline().strip()


n = int(input())

lib = defaultdict(lambda: float('inf'))

lib[3], lib[5] = 0, 0

for i in range(3, n + 1):
    lib[i] = min([lib[i], lib[i - 3], lib[i - 5]]) + 1

print(-1 if lib[n] == float('inf') else lib[n])