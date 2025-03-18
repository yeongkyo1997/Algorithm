import sys, itertools

input = lambda: sys.stdin.readline().rstrip()


N, M = map(int, input().split())

for p in itertools.permutations(range(1, N + 1), M):
    print(*p)
