import sys


def input(): return sys.stdin.readline().strip()


A, B, C = map(int, input().split())

if C <= B:
    print(-1)
else:
    profit = C - B
    result = A // profit + 1
    print(result)