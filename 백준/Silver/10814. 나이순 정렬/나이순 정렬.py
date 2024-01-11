import sys


def input(): return sys.stdin.readline().strip()


n = int(input())

arr = sorted([input().split() for _ in range(n)], key=lambda x: int(x[0]))

for i in arr:
    print(*i)