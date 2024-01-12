import sys
from itertools import permutations


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())

for i in permutations(sorted(map(int, input().split())), M):
    print(*i)