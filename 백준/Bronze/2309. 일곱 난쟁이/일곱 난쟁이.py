import sys
from itertools import combinations


def input(): return sys.stdin.readline().rstrip()


arr = [int(input()) for _ in range(9)]


for i in combinations(arr, 7):
    if sum(i) == 100:
        print(*sorted(i), sep='\n')
        break