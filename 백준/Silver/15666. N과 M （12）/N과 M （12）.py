import sys
from itertools import combinations_with_replacement


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())

result = set()
for i in combinations_with_replacement(sorted(map(int, input().split())), M):
    result.add(i)

for i in sorted(result):
    print(*i)