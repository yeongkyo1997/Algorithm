import sys


def input(): return sys.stdin.readline().strip()


input()

print(sum(map(int, input())))