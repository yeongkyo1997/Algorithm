import sys
from itertools import permutations


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())

for i in permutations(range(1, N + 1), M):
    print(*i)