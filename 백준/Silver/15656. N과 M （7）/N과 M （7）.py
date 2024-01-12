import sys
from itertools import product


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())

for i in product(sorted(map(int, input().split())), repeat=M):
    print(*i)