import sys
from itertools import combinations


def input(): return sys.stdin.readline().rstrip()


L, C = map(int, input().split())

arr = input().split()
arr.sort()
for i in combinations(arr, L):
    if len(list(a for a in i if a in 'aeiou')) >= 1 and len(list(a for a in i if not a in 'aeiou')) >= 2:
        print(''.join(i))