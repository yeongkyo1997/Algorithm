import sys
from itertools import combinations


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())

for i in combinations(sorted(map(int, input().split())), M):
    print(*i)