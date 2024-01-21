import sys


def input(): return sys.stdin.readline().rstrip()


print(sum(map(int, input().split())))