import sys, itertools


input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())

for c in itertools.combinations_with_replacement(range(1, N + 1), M):
    print(*c)
