import sys
from itertools import combinations


def input(): return sys.stdin.readline().strip()


N, M = map(int, input().split())
arr = list(map(int, input().split()))

print(max(sum(i) for i in combinations(arr, 3) if sum(i) <= M))