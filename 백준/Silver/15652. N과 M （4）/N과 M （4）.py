import itertools
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())

for i in itertools.combinations_with_replacement(range(1, N + 1), M):
    print(*i)
