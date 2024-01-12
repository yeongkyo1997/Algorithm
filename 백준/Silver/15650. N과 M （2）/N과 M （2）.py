import sys
from itertools import combinations


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())

for i in combinations(range(1, N + 1), M):
    print(*i)