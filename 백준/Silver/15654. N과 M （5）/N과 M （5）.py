import sys, itertools


input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
for c in itertools.permutations(arr, M):
    print(*c)
