import sys, itertools


input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
result = set()
for c in itertools.combinations(arr, M):
    result.add(c)

for r in sorted(result):
    print(*r)
