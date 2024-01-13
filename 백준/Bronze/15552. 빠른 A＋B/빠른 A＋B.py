import sys


def input(): return sys.stdin.readline().rstrip()


n = int(input())

for _ in range(n):
    print(sum(map(int, input().split())))