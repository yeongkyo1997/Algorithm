import itertools
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())

for i in itertools.permutations(sorted(list(map(int, input().split()))), M):
    print(*i)