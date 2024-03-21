import sys


def input(): return sys.stdin.readline().rstrip()


T = int(input())

for _ in range(T):
    N = int(input())
    print(sum(map(int, input().split())))