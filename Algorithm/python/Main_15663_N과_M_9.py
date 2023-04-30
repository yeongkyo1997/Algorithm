import itertools

import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())

arr = set()
for i in sorted(set(itertools.permutations(map(int, input().split()), M))):
    arr.add(i)

for i in sorted(arr):
    print(*i)
