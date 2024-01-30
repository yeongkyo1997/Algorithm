import sys
from itertools import combinations


def input(): return sys.stdin.readline().rstrip()


N, S = map(int, input().split())

arr = list(map(int, input().split()))

result = 0
for i in range(1, N + 1):
    for j in combinations(arr, i):
        if sum(j) == S:
            result += 1

print(result)