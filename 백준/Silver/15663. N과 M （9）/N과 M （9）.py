import sys
from itertools import permutations


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())

result = set()
for i in permutations(map(int, input().split()), M):
    result.add(i)

for i in sorted(result):
    print(*i)